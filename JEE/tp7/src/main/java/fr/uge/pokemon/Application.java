package fr.uge.pokemon;

import fr.uge.pokemon.service.PokemonService;
import fr.uge.pokemon.utils.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext config = new AnnotationConfigApplicationContext(Config.class);
        var service = new PokemonService();

    }
}
