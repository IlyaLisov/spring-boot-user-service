package io.github.ilyalisov.springbootuserservice.repository;

import io.github.ilyalisov.springbootuserservice.model.AbstractUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository<ID>
        extends JpaRepository<AbstractUser<ID>, ID> {

    /**
     * Finds a user by their username.
     *
     * @param username username
     * @return found user
     */
    Optional<AbstractUser<ID>> findByUsername(String username);

    /**
     * Checks whether user exists by their username.
     *
     * @param username username
     * @return true - if user exists, false - otherwise
     */
    boolean existsByUsername(String username);

    /**
     * Deletes a user from database by their username.
     *
     * @param username username
     */
    void deleteByUsername(String username);

}
