package se.iths.charity_shop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.charity_shop.entity.RoleEntity;
import se.iths.charity_shop.service.RoleService;
import java.util.Optional;

@RestController
@RequestMapping("roles")

public class RoleController {

    RoleService roleService;
    public RoleController(RoleService roleService){this.roleService = roleService;}

    @PostMapping
    public ResponseEntity<RoleEntity> createRole(@RequestBody RoleEntity roleEntity){
        RoleEntity createdRole = roleService.createRole(roleEntity);
        return new ResponseEntity(createdRole, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public void deleteRole(@PathVariable Long id){roleService.deleteRole(id);}

    @GetMapping("{id}")
    public Optional<RoleEntity> findRoleById(@PathVariable Long id){
        return roleService.findRoleById(id);
    }

    @GetMapping
    public Iterable<RoleEntity> findAll(){return roleService.findAll();}
}
