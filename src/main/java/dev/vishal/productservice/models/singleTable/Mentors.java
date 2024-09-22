package dev.vishal.productservice.models.singleTable;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_mentors")
@DiscriminatorValue("3")
public class Mentors extends Users {

    private int sessions;
}
