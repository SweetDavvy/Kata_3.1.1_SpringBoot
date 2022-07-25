package com.example.demo.model;


import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String name;


    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    public User(String name, String lastName, Integer age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;

    }

    public User() {

    }

    public void setId(Long id) {

        this.id = id;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public void setAge(Integer age) {

        this.age = age;
    }

    public long getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public String getLastName() {

        return lastName;
    }

    public int getAge() {

        return age;
    }

    @Override
    public String toString() {
        return id +
                ", " + name +
                ", " + lastName +
                ", " + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
