package fr.uge.jee.hibernate.students.model;


import javax.persistence.*;

@Entity
@Table(name = "Comments")
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    public Comment() {
    }

    public Comment(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;

    }
}
