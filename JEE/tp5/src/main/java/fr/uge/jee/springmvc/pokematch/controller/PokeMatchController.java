package fr.uge.jee.springmvc.pokematch.controller;

import fr.uge.jee.springmvc.pokematch.dto.PokemonDTO;
import fr.uge.jee.springmvc.pokematch.dto.PokemonGQLDTO;
import fr.uge.jee.springmvc.pokematch.dto.PokemonReferenceDTO;
import fr.uge.jee.springmvc.pokematch.model.FavoritePokemon;
import fr.uge.jee.springmvc.pokematch.model.Pokemon;
import fr.uge.jee.springmvc.pokematch.model.User;
import fr.uge.jee.springmvc.pokematch.service.PokeMatchService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import javax.validation.Valid;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Controller
public class PokeMatchController {

    private final PokeMatchService service;
    private final FavoritePokemon favoritePokemons;

    @Value("${favorites.number}")
    private Integer maxFavoritesPokemon;

    public PokeMatchController(PokeMatchService service) {
        this.service = service;
        this.favoritePokemons = new FavoritePokemon();
    }

    @ModelAttribute("member")
    public User user() {
        return new User();
    }

    @GetMapping("/authentication")
    public String getForm() { return "authentication";}


    @GetMapping("/home")
    public String getHome(
        Model model,
        @ModelAttribute("member") User member
    ) {
        var flux = Flux.merge(service.fetchReferences());
        var optionalPokemonReferences = flux.toStream().findFirst().map(PokemonReferenceDTO::toModel);
        try {
            var pokemonsReferences = optionalPokemonReferences.orElseThrow();
            var pokemonsDTO = service.convertReferencesToPokemon(pokemonsReferences);
            var pokemons = pokemonsDTO.stream().map(PokemonDTO::toModel).collect(Collectors.toList());
            var pokemon = favoritePokemons.findMostCompatiblePokemon(
                pokemons,
                member
            );
            var top = favoritePokemons.getTopPokemons(maxFavoritesPokemon);
            model.addAttribute("compatiblePokemon", pokemon);
            model.addAttribute("favoritePokemons", top);
            model.addAttribute("user", member);
            model.addAttribute("pokemonImageUrl", service.fetchImage(pokemon.getImageUrl()));
        } catch (NoSuchElementException e) {
            return "home";
        }
        return "home";
    }


    @PostMapping("/authentication")
    public String registerUser(
        @Valid @ModelAttribute User user,
        BindingResult bindingResult,
        Model model,
        @ModelAttribute("member") User member
    ) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(System.out::println);
            model.addAttribute("errorForm", "Veuillez entrer que des lettres");
            return "authentication-error";
        }
        model.addAttribute("user", user);
        getHome(model, member);
        return "home";
    }


    @QueryMapping
    public PokemonReferenceDTO references() {
        var flux = Flux.merge(service.fetchReferences());
        var optionalPokemonReferences = flux.toStream().findFirst();
        return optionalPokemonReferences.orElseThrow();
    }

    @QueryMapping
    public PokemonDTO pokemon(@Argument String name) {
        var flux = Flux.merge(service.fetchPokemonFromName(name));
        var optionalPokemon = flux.toStream().findFirst();
        return optionalPokemon.orElseThrow();
    }

    @QueryMapping
    public PokemonGQLDTO pokemonGQL(@Argument int id) {
        var pokemonGl = service.fetchGQLPokemon(id);
        return pokemonGl;
    }


}
