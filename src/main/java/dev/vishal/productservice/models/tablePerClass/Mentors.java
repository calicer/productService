package dev.vishal.productservice.models.tablePerClass;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Mentors extends Users {
    private int sessions;
}
