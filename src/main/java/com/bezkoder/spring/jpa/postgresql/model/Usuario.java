package com.bezkoder.spring.jpa.postgresql.model;

import com.bezkoder.spring.jpa.postgresql.enums.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Usuario")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String login;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String nome;
    private String sobrenome;
    private String email;

    @Transient
    private String token;

    @Enumerated(EnumType.ORDINAL)
    private Role role;

    @ManyToMany
    private List<Acao> acoesFavoritas;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role != null ? role.getAuthorities() : new ArrayList<>();
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"login\":\"" + login + "\"" +
                ", \"nome\":\"" + nome + "\"" +
                ", \"sobrenome\":\"" + sobrenome + "\"" +
                ", \"email\":\"" + email + "\"" +
                ", \"token\":\"" + token + "\"" +
                "}";
    }
}
