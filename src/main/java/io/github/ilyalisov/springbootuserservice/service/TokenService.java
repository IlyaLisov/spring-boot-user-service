package io.github.ilyalisov.springbootuserservice.service;

import io.github.ilyalisov.springbootuserservice.model.TokenParameters;

import java.util.HashMap;

public interface TokenService {

    String generate(TokenParameters params);

    boolean isValid(String token);

    HashMap<String, Object> fields(String token);

}
