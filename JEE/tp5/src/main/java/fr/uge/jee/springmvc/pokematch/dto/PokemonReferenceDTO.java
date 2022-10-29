package fr.uge.jee.springmvc.pokematch.dto;

import fr.uge.jee.springmvc.pokematch.model.Pokemon;
import fr.uge.jee.springmvc.pokematch.model.PokemonReference;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PokemonReferenceDTO {


    private int count;
    private List<Map<String, String>> results;

    public PokemonReferenceDTO() {

    }

    public PokemonReferenceDTO(int count, List<Map<String, String>> results) {
        this.count = count;
        this.results = results;
    }

    public List<PokemonReference> toModel() {
        return results
            .stream()
            .map((m) -> new PokemonReference(m.get("name"), m.get("url")))
            .collect(Collectors.toUnmodifiableList());
    }
}
