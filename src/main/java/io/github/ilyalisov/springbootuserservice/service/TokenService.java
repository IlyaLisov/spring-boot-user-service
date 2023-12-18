package io.github.ilyalisov.springbootuserservice.service;

import io.github.ilyalisov.springbootuserservice.model.TokenParameters;

import java.util.HashMap;

public interface TokenService {

    /**
     * Generates JWT token with provided params.
     *
     * @param params params
     * @return JWT token
     */
    String generate(TokenParameters params);

    /**
     * Checks whether token is not expired
     * and generated with corresponding JWT secret.
     *
     * @param token token
     * @return true - if token is not expired and corresponds JWT secret,
     * false - otherwise
     */
    boolean isValid(String token);

    /**
     * Returns all fields from token payload.
     *
     * @param token token
     * @return map of fields of token payload
     */
    HashMap<String, Object> fields(String token);

}
