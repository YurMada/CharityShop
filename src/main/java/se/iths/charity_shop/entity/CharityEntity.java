package se.iths.charity_shop.entity;


import javax.persistence.*;

@Entity
public class CharityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double amount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private StockEntity stocks;

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
}