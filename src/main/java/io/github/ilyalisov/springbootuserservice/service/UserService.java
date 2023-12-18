package io.github.ilyalisov.springbootuserservice.service;

import io.github.ilyalisov.springbootuserservice.model.AbstractUser;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService<ID> {

    AbstractUser<ID> getById(ID id);

    AbstractUser<ID> getByUsername(String username);

    List<AbstractUser<ID>> getAll();

    List<AbstractUser<ID>> getAll(Pageable pageable);

    AbstractUser<ID> save(AbstractUser<ID> user);

    boolean existsById(ID id);

    boolean existsByUsername(String username);

    void deleteById(ID id);

    void deleteByUsername(String username);

}
