package io.github.ilyalisov.springbootuserservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractUser<ID> {

    protected ID id;
    protected String firstName;
    protected String lastName;
    protected String username;
    protected String password;
    protected String phone;

}
