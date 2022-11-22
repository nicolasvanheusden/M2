package fr.uge.jee.hibernate.students.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Lectures")
public class Lecture {

    @Id
    @GeneratedValue
    private Long id;


    private String name;

    public Lecture() {
    }

    public Lecture(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
