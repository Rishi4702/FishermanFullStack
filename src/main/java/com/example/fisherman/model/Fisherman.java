package com.example.fisherman.model;

import com.example.fisherman.DTO.FishermanDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fishermans")
public class Fisherman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name",unique = true)
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "age")
    private int age;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;

    public Fisherman() {

    }

    public List<ModelCatch> getModelCatches() {
        return modelCatches;
    }

    public void setModelCatches(List<ModelCatch> modelCatches) {
        this.modelCatches = modelCatches;
    }

    public Fisherman(String name, String password, int age, String email, String phone) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    @OneToMany(mappedBy = "fisherman", cascade = CascadeType.ALL)
    private List<ModelCatch> modelCatches = new ArrayList<>();

    public FishermanDTO toDTO(Fisherman s) {
        return new FishermanDTO().age(s.age).id(BigDecimal.valueOf(s.id)).name(s.name).email(s.getEmail()).phone(s.getPhone());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Fisherman{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}
