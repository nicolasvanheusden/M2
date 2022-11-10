package fr.uge.jee.hibernate;

import fr.uge.jee.hibernate.employees.EmployeeRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {

    public static void main(String[] args) {
        var repository = new EmployeeRepository();

        repository.create("Bob", "Moran", 500);
        repository.create("Bob", "Dylan", 600);
        repository.create("Lisa", "Simpson", 100);
        repository.create("Marge", "Simpson", 1000);
        repository.create("Homer", "Simpson", 450);

        repository.delete(3L);
        repository.update(5L, 550);

        repository.updateSalary(1L);
        repository.updateSalary(3L);
        repository.updateSalary(5L);

        System.out.println(repository.getAll());

        System.out.println(repository.getAllByFirstName("Bob"));


    }
}
