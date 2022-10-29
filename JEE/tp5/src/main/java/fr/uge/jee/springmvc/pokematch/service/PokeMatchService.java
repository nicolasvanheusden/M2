package fr.uge.jee.springmvc.pokematch.service;

import fr.uge.jee.springmvc.pokematch.dto.PokemonReferenceDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PokeMatchService {

    private final WebClient client;

    public PokeMatchService(WebClient webClient) {
        this.client = webClient;
    }

    public Mono<PokemonReferenceDTO> fetchReferences() {
        return client.get()
            .uri("https://pokeapi.co/api/v2/pokemon?limit=40&offset=0")
            .retrieve()
            .bodyToMono(PokemonReferenceDTO.class);
    }





}
