package za.ac.cput.vehicledealership.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.ERole;
import za.ac.cput.vehicledealership.domain.Role;
import za.ac.cput.vehicledealership.repository.RoleRepository;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;


    public Role findByName(ERole name) {
        return roleRepository.findByName(name);
    }
}
