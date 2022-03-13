package se.iths.charity_shop.service;

import org.springframework.stereotype.Service;
import se.iths.charity_shop.entity.RoleEntity;
import se.iths.charity_shop.repository.RoleRepository;
import java.util.Optional;

@Service
public class RoleService {

    RoleRepository roleRepository;

    public RoleService( RoleRepository roleRepository) {this.roleRepository = roleRepository;}

    public RoleEntity createRole(RoleEntity roleEntity) {return roleRepository.save(roleEntity);}

    public void deleteRole(Long id) {
        Optional<RoleEntity> foundRole = roleRepository.findById(id);
        roleRepository.deleteById(id);
    }

    public Optional<RoleEntity> findRoleById(Long id) {return roleRepository.findById(id);}

    public Iterable<RoleEntity> findAll() {return roleRepository.findAll();}
}
