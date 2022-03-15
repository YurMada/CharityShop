package se.iths.charity_shop.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> users = new HashSet<>();

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<UserEntity> getUsers() {
        return users;
    }
    public RoleEntity setUsers(Set<UserEntity> users) {
        this.users = users;
        return this;
    }
}
