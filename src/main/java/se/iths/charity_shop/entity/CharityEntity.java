package se.iths.charity_shop.entity;

import javax.persistence.*;

@Entity
public class CharityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double amount;

    @ManyToOne
    private StockEntity stocks;

    public CharityEntity() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public StockEntity getStocks() {
        return stocks;
    }

    public void setStocks(StockEntity stocks) {
        this.stocks = stocks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}