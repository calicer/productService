package dev.vishal.productservice.models.mappedSuperClass;


import jakarta.persistence.*;

@MappedSuperclass
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String email;
    private int age;
}
