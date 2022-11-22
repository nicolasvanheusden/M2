package fr.uge.jee.hibernate.students.model;


import javax.persistence.*;

@Entity
@Table(name = "Address")
@Embeddable
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    private String address;

    public Address(String address) {
        this.address = address;
    }

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
