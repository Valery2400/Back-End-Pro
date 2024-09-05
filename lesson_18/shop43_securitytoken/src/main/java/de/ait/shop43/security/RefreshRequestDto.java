package de.ait.shop43.security;

import lombok.Getter;

import java.util.Objects;

@Getter
public class RefreshRequestDto {
    private String refreshToken;

    @Override
    public String toString() {
        return "RefreshRequest Token: " +
                 refreshToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RefreshRequestDto that = (RefreshRequestDto) o;
        return Objects.equals(refreshToken, that.refreshToken);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(refreshToken);
    }
}
