package fr.uge.jee.hibernate.students.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="Lectures")
public class Lecture {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany
    private Set<Student> students;

    public Lecture() {
    }

    public Lecture(String name) {
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

    public Set<Student> getStudents() {
        return students;
    }

    public Lecture setStudents(Set<Student> students) {
        this.students = students;
        return this;
    }

    public void addStudent(Student student) {
        Objects.requireNonNull(student);
        if (!students.contains(student)) {
            students.add(student);
            student.addLecture(this);
        }

    }

    public void removeStudent(Student student) {
        Objects.requireNonNull(student);
        if (students.contains(student)) {
            students.remove(student);
            student.removeLecture(null);
        }

    }
}
