package com.bezkoder.spring.jpa.postgresql.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.bezkoder.spring.jpa.postgresql.enums.Permissao.*;

@RequiredArgsConstructor
public enum Role {
    USUARIO(
            Set.of(
                    USER_FREE
            )
    ),
    ADMINISTRADOR(
            Set.of(
                    ADMIN,
                    USER_FREE,
                    USER_PLUS,
                    USER_PREMIUM
            )
    ),
    USUARIO_PLUS(
            Set.of(
                    USER_PLUS,
                    USER_FREE
            )
    ),

    USUARIO_PREMIUM(
            Set.of(
                    USER_PLUS,
                    USER_PREMIUM,
                    USER_FREE
            )
    );

    @Getter
    private final Set<Permissao> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }

}
