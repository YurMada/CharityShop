package se.iths.charity_shop.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double amount;

    @OneToMany(mappedBy = "stockEntity", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<DonationEntity> donationEntity;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Set<DonationEntity> getDonationEntity() {
        return donationEntity;
    }

    public void setDonationEntity(Set<DonationEntity> donationEntity) {
        this.donationEntity = donationEntity;
    }



}