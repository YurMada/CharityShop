package se.iths.charity_shop.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.charity_shop.entity.CharityEntity;

@Repository
public interface CharityRepository extends CrudRepository<CharityEntity, Long>{
    @Query("SELECT SUM(m.amount) FROM CharityEntity m")
    public double getTotalAmount();

}