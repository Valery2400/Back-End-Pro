package de.ait.shop43.security;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class RoleServiceImp implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role getRoleByTitle(String title) {
        return roleRepository.findRoleByTitle(title);
    }
}
