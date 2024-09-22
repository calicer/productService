package dev.vishal.productservice.models.mappedSuperClass;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ms_mentors")
public class Mentors extends Users {

    private int sessions;
}
