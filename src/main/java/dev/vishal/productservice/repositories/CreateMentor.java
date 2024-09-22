package dev.vishal.productservice.repositories;

import dev.vishal.productservice.models.tablePerClass.Mentors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreateMentor extends JpaRepository<Mentors, Long> {

    Mentors save(Mentors mentor);
}
