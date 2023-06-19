package com.bezkoder.spring.jpa.postgresql.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permissao {
    ADMIN("admin"),
    USER_FREE("user:free"),
    USER_PLUS("user:plus"),
    USER_PREMIUM("user:premium")
    ;

    @Getter
    private final String permission;

}
