package fr.uge.jee.springmvc.reststudents;

import fr.uge.jee.springmvc.reststudents.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public CommandLineRunner printStudent(ApplicationContext applicationContext) {
        WebClient webClient = WebClient.create();
        Mono<Student> monoStudent = webClient.get()
            .uri("http://localhost:8080/students/1")
            .retrieve()
            .bodyToMono(Student.class);
        return args -> {
            monoStudent.flux().toStream().forEach(System.out::println);
        };
    }

    @Bean
    public CommandLineRunner printAllStudents(ApplicationContext applicationContext) {
        WebClient webClient = WebClient.create();
        Flux<Student> fluxStudent = webClient.get()
            .uri("http://localhost:8080/students/")
            .retrieve()
            .bodyToFlux(Student.class);

        return args -> {
            fluxStudent.toStream().forEach(System.out::println);
        };
    }

}