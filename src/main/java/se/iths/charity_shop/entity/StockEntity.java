package se.iths.charity_shop.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double amount;

@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<CharityEntity> charityEntity= new HashSet<>();

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCharityEntity(Set<CharityEntity> charityEntity) {
        this.charityEntity = charityEntity;
    }

}
