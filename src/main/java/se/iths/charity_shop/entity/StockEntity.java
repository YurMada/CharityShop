package se.iths.charity_shop.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double amount;

    @OneToMany(mappedBy = "stocks", cascade = CascadeType.ALL)
    private List<CharityEntity> charities = new ArrayList<>();

    @OneToMany(mappedBy = "stocks", cascade = CascadeType.ALL)
    private List<DonationEntity> donations = new ArrayList<>();

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<CharityEntity> getCharities() {
        return charities;
    }

    public void setCharities(List<CharityEntity> charities) {
        this.charities = charities;
    }

    public List<DonationEntity> getDonations() {
        return donations;
    }

    public void setDonations(List<DonationEntity> donations) {
        this.donations = donations;
    }
}