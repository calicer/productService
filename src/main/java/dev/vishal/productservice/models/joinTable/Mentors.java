package dev.vishal.productservice.models.joinTable;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_mentor")
public class Mentors extends Users {

    private int sessions;
}
