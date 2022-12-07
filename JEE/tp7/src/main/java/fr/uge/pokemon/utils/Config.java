package fr.uge.pokemon.utils;

import fr.uge.pokemon.service.PokemonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

@ComponentScan
public class Config {

    @Bean
    DataSource getDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.p6spy.engine.spy.P6SpyDriver");
        dataSourceBuilder.url("jdbc:p6spy:h2:tcp://localhost/~/h2DB");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }

    @Bean
    public CommandLineRunner cmd(PokemonService pokemonService){
        return args -> {
            var threads = new ArrayList<Thread>();
            for (int i = 0; i < 100; i++) {
                var thread=new Thread(() -> {
                    for (int j = 0; j < 100; j++) {
                        var name = ""+ ThreadLocalRandom.current().nextInt(100);
                        pokemonService.insertOrIncrementPokemon("balbuzar"+name);
                    }
                });
                threads.add(thread);
                thread.start();
            }
            for(var thread : threads){
                thread.join();
            }
            System.out.println(pokemonService.totalCountVote("balbuzar"));
        };
    }
}
