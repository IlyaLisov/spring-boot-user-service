package io.github.ilyalisov.springbootuserservice.repository;

import io.github.ilyalisov.springbootuserservice.model.AbstractUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository<ID> extends JpaRepository<AbstractUser<ID>, ID> {

    Optional<AbstractUser<ID>> findByUsername(String username);

    boolean existsByUsername(String username);

    void deleteByUsername(String username);

}
