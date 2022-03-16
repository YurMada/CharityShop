package se.iths.charity_shop.entity;


import javax.persistence.*;

@Entity
public class DonationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double amount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private StockEntity stockEntity;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public StockEntity getStockEntity() {
        return stockEntity;
    }

    public void setStockEntity(StockEntity stockEntity) {
        this.stockEntity = stockEntity;
    }

}