package fr.uge.jee.springmvc.pokematch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.uge.jee.springmvc.pokematch.model.Pokemon;


import java.util.List;

public class PokemonGQLDTO {

    @JsonProperty("data")
    private PokemonGQLDTOInner data;

    public PokemonGQLDTO(PokemonGQLDTOInner data) {
        this.data = data;
    }

    public PokemonGQLDTO() {
    }

    public PokemonGQLDTOInner getData() {
        return data;
    }

    public void setData(PokemonGQLDTOInner data) {
        this.data = data;
    }

    private static class PokemonGQLDTOInner {

        @JsonProperty("pokemon_v2_pokemonformsprites")
        private List<Sprites> pokemonV2Pokemonformsprites;
        @JsonProperty("pokemon_v2_pokemon")
        private List<PokemonV2> pokemonV2;

        public PokemonGQLDTOInner(List<Sprites> pokemonV2Pokemonformsprites, List<PokemonV2> pokemonV2) {
            this.pokemonV2Pokemonformsprites = pokemonV2Pokemonformsprites;
            this.pokemonV2 = pokemonV2;
        }


        public PokemonGQLDTOInner() {
        }

        public List<Sprites> getPokemonV2Pokemonformsprites() {
            return pokemonV2Pokemonformsprites;
        }

        public void setPokemonV2Pokemonformsprites(List<Sprites> pokemonV2Pokemonformsprites) {
            this.pokemonV2Pokemonformsprites = pokemonV2Pokemonformsprites;
        }

        public List<PokemonV2> getPokemonV2() {
            return pokemonV2;
        }

        public void setPokemonV2(List<PokemonV2> pokemonV2) {
            this.pokemonV2 = pokemonV2;
        }

        private static class Sprites {
            @JsonProperty("sprites")
            private String sprites;

            public Sprites(String sprites) {
                this.sprites = sprites;
            }

            public Sprites() {
            }

            public String getSprites() {
                return sprites;
            }

            public void setSprites(String sprites) {
                this.sprites = sprites;
            }

            @Override
            public String toString() {
                return "Sprites{" +
                    "sprites='" + sprites + '\'' +
                    '}';
            }
        }

        private static class PokemonV2 {

            @JsonProperty("id")
            private int id;
            @JsonProperty("name")
            private String name;
            @JsonProperty("base_experience")
            private int baseExperience;

            public PokemonV2() {
            }

            public PokemonV2(int id, String name, int baseExperience) {
                this.id = id;
                this.name = name;
                this.baseExperience = baseExperience;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getBaseExperience() {
                return baseExperience;
            }

            public void setBaseExperience(int baseExperience) {
                this.baseExperience = baseExperience;
            }

            @Override
            public String toString() {
                return "PokemonV2{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", baseExperience=" + baseExperience +
                    '}';
            }
        }

        @Override
        public String toString() {
            return "PokemonGQLDTOInner{" +
                "pokemonV2Pokemonformsprites=" + pokemonV2Pokemonformsprites +
                ", pokemonV2=" + pokemonV2 +
                '}';
        }
    }


    public Pokemon toModel() {
        var input = data.pokemonV2Pokemonformsprites.get(0).sprites;
        var sprite = SpritesDTO.fromJson(input);
        var pokemonV2 = data.pokemonV2.get(0);
        return new Pokemon(
            pokemonV2.id,
            pokemonV2.name,
            sprite.getFrontDefault(),
            pokemonV2.baseExperience
        );
    }

    @Override
    public String toString() {
        return "PokemonGQLDTO{" +
            "data=" + data +
            '}';
    }
}
