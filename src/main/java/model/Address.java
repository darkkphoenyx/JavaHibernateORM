package model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String type;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    public Address(Integer id, String name, String type, Student student) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.student = student;
    }

    public Address(String name, String type, Student student) {
        this.name = name;
        this.type = type;
        this.student = student;
    }

    public Address(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Address() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", student=" + student +
                '}';
    }
}
