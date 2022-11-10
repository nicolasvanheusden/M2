package fr.uge.jee.springmvc.pokematch.service;

import fr.uge.jee.springmvc.pokematch.dto.PokemonDTO;
import fr.uge.jee.springmvc.pokematch.dto.PokemonGQLDTO;
import fr.uge.jee.springmvc.pokematch.dto.PokemonReferenceDTO;
import fr.uge.jee.springmvc.pokematch.model.PokemonReference;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<PokemonDTO> convertReferencesToPokemon(List<PokemonReference> references) {
        return Flux.merge(
            references
                .stream()
                .map(reference -> fetchPokemonFromName(reference.getName()))
                .collect(Collectors.toList())
        ).toStream().collect(Collectors.toList());
    }
    public Mono<PokemonDTO> fetchPokemonFromName(String name) {
        return client.get()
            .uri("https://pokeapi.co/api/v2/pokemon/"+name)
            .retrieve()
            .bodyToMono(PokemonDTO.class);
    }


    @Cacheable("images")
    public String fetchImage(String url) {
        System.out.println("call image");
        var bytes = client.get()
            .uri(url)
            .retrieve()
            .bodyToMono(byte[].class)
            .block();
        return Base64.getEncoder().encodeToString(bytes);
    }


    public PokemonGQLDTO fetchGQLPokemon(int id) {
        var schema = "{\"query\":\"query samplePokeAPIquery {\\n    pokemon_v2_pokemonformsprites(where: {id: {_eq: "+id+"}}) {\\n        sprites\\n        }\\n        pokemon_v2_pokemon(where: {id: {_eq: "+id+"}}) {\\n            name\\n            id\\n            base_experience\\n        }\\n}\\n\",\"variables\":{}}";

        var response = client.post()
            .uri("https://beta.pokeapi.co/graphql/v1beta")
            .bodyValue(schema)
            .retrieve();

        return response
            .bodyToMono(PokemonGQLDTO.class)
            .block()
            ;

    }





}
