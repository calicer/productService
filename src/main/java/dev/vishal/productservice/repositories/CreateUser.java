package dev.vishal.productservice.repositories;

import dev.vishal.productservice.models.tablePerClass.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CreateUser extends JpaRepository<Users, Long> {

    Users save(Users user);
}
