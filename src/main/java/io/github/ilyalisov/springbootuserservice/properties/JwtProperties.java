package io.github.ilyalisov.springbootuserservice.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    /**
     * Secret for generated JWT tokens.
     */
    private String secret;

}
