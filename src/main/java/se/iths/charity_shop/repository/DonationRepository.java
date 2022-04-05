package se.iths.charity_shop.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.charity_shop.entity.DonationEntity;

@Repository
public interface DonationRepository extends CrudRepository<DonationEntity,Long> {
    @Query("SELECT SUM(m.amount) FROM DonationEntity m")
    double getTotalAmount();


}
