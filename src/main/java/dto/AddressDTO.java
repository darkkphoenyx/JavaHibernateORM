package dto;

import jakarta.persistence.*;
import model.Student;

public class AddressDTO {
    private Integer id;
    private String name;
    private String type;
    private Integer student_id;

    public AddressDTO(Integer id, String name, String type, Integer student_id) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.student_id = student_id;
    }

    public AddressDTO(String name, String type, Integer student_id) {
        this.name = name;
        this.type = type;
        this.student_id = student_id;
    }

    public AddressDTO() {
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

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }
}
