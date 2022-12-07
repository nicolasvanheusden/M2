package fr.uge.jee.hibernate.students.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Universities")
public class University {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="university")
    private Set<Student> students;

    public University() {
    }

    public University(String name) {
        this.name = name;
        this.students = new HashSet<>();
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

    public void addStudent(Student student) {
        Objects.requireNonNull(student);
        if(!students.contains(student)) {
            students.add(student);
            student.setUniversity(this);
        }
        
    }

    public void removeStudent(Student student) {
        Objects.requireNonNull(student);
        if (students.contains(student)) {
            students.remove(student);
            student.setUniversity(null);
        }

    }
}
