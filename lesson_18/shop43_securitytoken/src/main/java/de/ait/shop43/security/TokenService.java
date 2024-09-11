package de.ait.shop43.security;

import de.ait.shop43.role.Role;
import de.ait.shop43.role.RoleRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
public class TokenService {
    public static final int ACCESS_DAYS = 7;
    public static final int REFRESH_DAYS = 30;
    private SecretKey accessKey;
    private SecretKey refreshKey;
    private final RoleRepository roleRepository;

    // https://www.devglan.com/online-tools/hmac-sha256-online
    //access key
// oxCIJkAR/pepyVVpChYM3UhUfsjY8jfkSyqp7Do9xFc=

    // refresh key
// T8QmKiJpXwG0OCXyqJRQ0i9IN5/7G37HPmQqKyOoEd4=


    public TokenService(@Value("${key.access}") String accessPhrase,
                        @Value("${key.refresh}") String refreshPhrase,
                        @Autowired RoleRepository roleRepository) {
        this.accessKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(accessPhrase));
        this.refreshKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(refreshPhrase));
        this.roleRepository = roleRepository;
    }

    private Date getExpirationDate(int days) {
        LocalDateTime currentDate = LocalDateTime.now();
        Instant expiration = currentDate.plusDays(days)
                .atZone(ZoneId.systemDefault())
                .toInstant();
        Date expirationDate = Date.from(expiration);
        return expirationDate;
    }

    public String generateAccessToken(User user) {

        Date expirationDate = getExpirationDate(ACCESS_DAYS);

        return Jwts.builder()
                .subject(user.getUsername())
                .expiration(expirationDate)
                .claim("roles", user.getRoles())
                .claim("name", user.getUsername())
                .signWith(accessKey)
                .compact();
    }

    public String generateRefreshToken(User user) {
        Date expirationDate = getExpirationDate(REFRESH_DAYS);
        return Jwts.builder()
                .subject(user.getUsername())
                .expiration(expirationDate)
                .signWith(refreshKey)
                .compact();
    }

    private boolean validateToken(String token, SecretKey key) {
        try {
            Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean validateAccessToken(String accessToken) {
        return validateToken(accessToken, accessKey);
    }

    public boolean validateRefreshToken(String refreshToken) {
        return validateToken(refreshToken, refreshKey);
    }

    private Claims getClaims(String token, SecretKey key) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public Claims getAccessClaims(String accessToken) {
        return getClaims(accessToken, accessKey);
    }

    public Claims getRefreshClaims(String refreshToken) {
        return getClaims(refreshToken, refreshKey);
    }

    public AuthInfo mapClaimsToAuthInfo(Claims claims) {
        String username = claims.getSubject();
        List<LinkedHashMap<String, String>> rolesList = (List<LinkedHashMap<String, String>>) claims.get("roles");

        Set<Role> roles = new HashSet<>();
        for (LinkedHashMap<String, String> roleEntry : rolesList) {
            String roleTitle = roleEntry.get("authority");
            Role role = roleRepository.findRoleByTitle(roleTitle);
            if (role != null) {
                roles.add(role);
            }
        }
        return new AuthInfo(username, roles);
    }
}