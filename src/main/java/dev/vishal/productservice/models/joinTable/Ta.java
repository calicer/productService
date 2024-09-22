package dev.vishal.productservice.models.joinTable;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_ta")
public class Ta extends Users {
    private int rating;
}
