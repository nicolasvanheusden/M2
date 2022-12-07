package fr.uge.jee.hibernate.students.model;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    private String lastName;

    private String firstName;
    @Embedded
    private Address address;
    @OneToOne
    private University university;
    @OneToMany
    private List<Comment> comments;
    @ManyToMany
    private Set<Lecture> lectures;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Set<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(Set<Lecture> lectures) {
        this.lectures = lectures;
    }

    public String getLastName() {
        return lastName;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Student(String lastName, String firstName, Address address, University university, List<Comment> comments, Set<Lecture> lectures) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.university = university;
        this.comments = List.copyOf(comments);
        this.lectures = Set.copyOf(lectures);
    }

    public Student() {
    }

    public void addLecture(Lecture lecture) {
        Objects.requireNonNull(lecture);
        lectures.add(lecture);
    }

    public void addComment(Comment comment) {
        Objects.requireNonNull(comment);
        comments.add(comment);
    }

    public void removeComment(Comment comment) {
        Objects.requireNonNull(comment);
        comments.remove(comment);
    }


}
