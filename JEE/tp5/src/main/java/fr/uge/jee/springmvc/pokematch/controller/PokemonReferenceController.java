package fr.uge.jee.springmvc.pokematch.controller;



import fr.uge.jee.springmvc.pokematch.dto.PokemonReferenceDTO;
import fr.uge.jee.springmvc.pokematch.model.PokemonReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PokemonReferenceController {

    private final WebClient client;

    public PokemonReferenceController(WebClient client) {
        this.client = client;
    }

    @GetMapping("/pokemons/")
    public List<PokemonReference> getAllPokemon() {
        var fluxPokeReference = client.get()
            .uri("https://pokeapi.co/api/v2/pokemon?limit=40&offset=0")
            .retrieve()
            .bodyToFlux(PokemonReferenceDTO.class);

        fluxPokeReference.subscribe()
    }



}
