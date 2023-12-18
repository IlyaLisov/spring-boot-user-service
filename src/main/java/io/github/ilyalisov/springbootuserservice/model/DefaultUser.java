package io.github.ilyalisov.springbootuserservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class DefaultUser extends AbstractUser<Long> {
}
