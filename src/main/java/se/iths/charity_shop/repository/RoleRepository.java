package se.iths.charity_shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.charity_shop.entity.RoleEntity;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long>{
}