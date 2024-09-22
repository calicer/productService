package dev.vishal.productservice.models.joinTable;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_student")
public class Student extends Users {
    private int gradYear;
}
