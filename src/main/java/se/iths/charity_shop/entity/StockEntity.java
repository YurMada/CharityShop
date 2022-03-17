package se.iths.charity_shop.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double amount;

@OneToMany(cascade = CascadeType.ALL)
    private Set<CharityEntity> charityEntity;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDonationEntity(Set<DonationEntity> donationEntity) {
        this.donationEntity = donationEntity;
    }
    public void setCharityEntity(Set<CharityEntity> charityEntity) {
        this.charityEntity = charityEntity;
    }

}
