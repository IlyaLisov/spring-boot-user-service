package io.github.ilyalisov.springbootuserservice.service;

import io.github.ilyalisov.springbootuserservice.exceptions.UserNotFoundException;
import io.github.ilyalisov.springbootuserservice.model.AbstractUser;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService<ID> {

    /**
     * Returns user by their id.
     *
     * @param id id of user
     * @return found user
     * @throws UserNotFoundException - if user was not found
     */
    AbstractUser<ID> getById(ID id);

    /**
     * Returns user by their username.
     *
     * @param username username of user
     * @return found user
     * @throws UserNotFoundException - if user was not found
     */
    AbstractUser<ID> getByUsername(String username);

    /**
     * Returns all users.
     *
     * @return list of users
     */
    List<AbstractUser<ID>> getAll();

    /**
     * Returns all users with pagination.
     *
     * @param pageable pagination
     * @return list of users
     */
    List<AbstractUser<ID>> getAll(Pageable pageable);

    /**
     * Creates or updates user, validate unique username.
     *
     * @param user user to be saved
     * @return saved user
     */
    AbstractUser<ID> save(AbstractUser<ID> user);

    /**
     * Checks whether user with provided id exists.
     *
     * @param id id of user
     * @return true - if user exists
     */
    boolean existsById(ID id);

    /**
     * Checks whether user with provided username exists.
     *
     * @param username username of user
     * @return true - if user exists
     */
    boolean existsByUsername(String username);

    /**
     * Deletes user by their id.
     *
     * @param id id of user
     */
    void deleteById(ID id);

    /**
     * Deletes user by their username.
     *
     * @param username username of user
     */
    void deleteByUsername(String username);

}
