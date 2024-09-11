package de.ait.shop43.security;

import de.ait.shop43.role.Role;
import lombok.Getter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;



@Getter
public class AuthInfo implements Authentication {
    private boolean authenticated;
    private String username;
    private Set<Role> roles;

    public AuthInfo(String username, Set<Role> roles) {
        this.username = username;
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthInfo authInfo = (AuthInfo) o;
        return Objects.equals(username, authInfo.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }

    @Override
    public String getName() {
        return username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public Object getCredentials() {
        return null;
    }
    //позволяет сообщить способ авторизации, чаще всего это пароль

    @Override
    public Object getDetails() {
        return null;
    }
    //позволяет вернуть объект после дополнительных проверок

    @Override
    public Object getPrincipal() {
        return username; }
    // позволяет вернуть основную информацию о пользователе, фактически это логин

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }
}
