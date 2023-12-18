package io.github.ilyalisov.springbootuserservice.service;

import io.github.ilyalisov.springbootuserservice.exceptions.UserAlreadyExistsException;
import io.github.ilyalisov.springbootuserservice.exceptions.UserNotFoundException;
import io.github.ilyalisov.springbootuserservice.model.AbstractUser;
import io.github.ilyalisov.springbootuserservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl<ID> implements UserService<ID> {

    private final UserRepository<ID> userRepository;

    @Override
    public AbstractUser<ID> getById(
            final ID id
    ) {
        return userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public AbstractUser<ID> getByUsername(
            final String username
    ) {
        return userRepository.findByUsername(username)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<AbstractUser<ID>> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<AbstractUser<ID>> getAll(
            final Pageable pageable
    ) {
        return userRepository.findAll(pageable)
                .toList();
    }

    @Override
    public AbstractUser<ID> save(
            final AbstractUser<ID> user
    ) {
        if (user.getId() != null) {
            userRepository.findByUsername(
                    user.getUsername()
            ).ifPresent(u -> {
                if (!u.getId().equals(user.getId())) {
                    throw new UserAlreadyExistsException();
                }
            });
        } else {
            if (userRepository.existsByUsername(user.getUsername())) {
                throw new UserAlreadyExistsException();
            }
        }
        return userRepository.save(user);
    }

    @Override
    public boolean existsById(
            final ID id
    ) {
        return userRepository.existsById(id);
    }

    @Override
    public boolean existsByUsername(
            final String username
    ) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public void deleteById(
            final ID id
    ) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteByUsername(
            final String username
    ) {
        userRepository.deleteByUsername(username);
    }

}
