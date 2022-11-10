package fr.uge.jee.springmvc.pokematch.model;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class FavoritePokemon {

    private final ConcurrentHashMap<Pokemon, Integer> pokemonRanks;
    private final Object lock = new Object();

    public FavoritePokemon() {
        this.pokemonRanks = new ConcurrentHashMap<>();
    }


    public Pokemon findMostCompatiblePokemon(List<Pokemon> pokemons, User user) {
        Objects.requireNonNull(user);
        Objects.requireNonNull(pokemons);

        var closest = Integer.MAX_VALUE;
        Pokemon res = pokemons.stream().findFirst().orElseThrow();
        for (var pokemon: pokemons) {
            var compatible = Math.abs(pokemon.hashCode() - user.hashCode());
            if ( compatible < closest ) {
                closest = compatible;
                res = pokemon;
            }
        }
        incrementPokemonRank(res);
        return res;


    }


    private void incrementPokemonRank(Pokemon pokemon) {
        Objects.requireNonNull(pokemon);
        pokemonRanks.putIfAbsent(pokemon, 0);
        pokemonRanks.computeIfPresent(pokemon, (k, v) -> v+1);

    }

    public List<Pokemon> getTopPokemons(int numberOfPokemons) {
        return pokemonRanks
            .entrySet()
            .stream()
            .sorted((a, b) -> b.getValue() - a.getValue())
            .limit(numberOfPokemons)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());

    }

    private PokemonRanked extractMinimalRanked(ArrayList<PokemonRanked> pokemons, long minimalRank) {
        Objects.requireNonNull(pokemons);
        var minimalRankedPokemons = pokemons
            .stream()
            .filter(p -> p.rank == minimalRank)
            .collect(Collectors.toList());

        return minimalRankedPokemons.stream().findFirst().get();

    }

    private class PokemonRanked {
        private final Pokemon pokemon;
        private long rank;

        public PokemonRanked(Pokemon pokemon, long rank) {
            this.pokemon = pokemon;
            this.rank = rank;
        }

        @Override
        public String toString() {
            return "PokemonRanked{" +
                "pokemon=" + pokemon +
                ", rank=" + rank +
                '}';
        }
    }
}
