package fr.uge.pokemon.service;

import fr.uge.pokemon.model.Pokemon;
import fr.uge.pokemon.repository.PokemonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;


@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @PersistenceUnit
    EntityManagerFactory emf;

    @PersistenceContext
    EntityManager em;


    @Transactional
    public void insertOrIncrementPokemon(String name) {
        var pokemonToUpdate= em.find(Pokemon.class, name, LockModeType.PESSIMISTIC_WRITE);
        pokemonToUpdate.setScore(pokemonToUpdate.getScore()+1);
    }


    public long totalCountVote(String name) {
        var pokemon= em.find(Pokemon.class,name, LockModeType.PESSIMISTIC_WRITE);
        return pokemon.getScore();
    }

}