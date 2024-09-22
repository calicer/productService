package dev.vishal.productservice.repositories;

import dev.vishal.productservice.models.tablePerClass.Mentors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreateMentorMS extends JpaRepository<Mentors, Long> {

    Mentors save(Mentors mentors);
}
