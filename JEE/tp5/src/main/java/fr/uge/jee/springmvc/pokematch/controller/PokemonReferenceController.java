package fr.uge.jee.springmvc.pokematch.controller;



import fr.uge.jee.springmvc.pokematch.dto.PokemonReferenceDTO;
import fr.uge.jee.springmvc.pokematch.model.PokemonReference;
import fr.uge.jee.springmvc.pokematch.service.PokeMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PokemonReferenceController {

    private final PokeMatchService service;
    public PokemonReferenceController(PokeMatchService service) {
        this.service = service;
    }

    @GetMapping("/home")
    public List<PokemonReference> getAllPokemon() {
        Flux<PokemonReferenceDTO> flux = Flux.merge(service.fetchReferences());
        var otionalPokemons = flux.toStream().map(PokemonReferenceDTO::toModel).findFirst();
        return otionalPokemons.orElseGet(List::of);
    }



}
