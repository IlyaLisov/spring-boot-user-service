package io.github.ilyalisov.springbootuserservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractUser<ID> {

    /**
     * ID of user.
     */
    protected ID id;

    /**
     * First name of user.
     */
    protected String firstName;

    /**
     * Last name of user.
     */
    protected String lastName;

    /**
     * Username of user. UserService checks whether it is unique.
     */
    protected String username;

    /**
     * Password of user.
     */
    protected String password;

    /**
     * Phone of user.
     */
    protected String phone;

}
