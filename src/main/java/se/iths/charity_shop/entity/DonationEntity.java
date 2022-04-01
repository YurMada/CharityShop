package se.iths.charity_shop.entity;


import javax.persistence.*;

@Entity
public class DonationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double amount;

    @ManyToOne
    private StockEntity stocks;

    public DonationEntity() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}