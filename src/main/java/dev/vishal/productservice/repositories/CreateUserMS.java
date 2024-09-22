package dev.vishal.productservice.repositories;

import dev.vishal.productservice.models.mappedSuperClass.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreateUserMS extends JpaRepository<Users, Long> {

    Users save(Users users);

}
