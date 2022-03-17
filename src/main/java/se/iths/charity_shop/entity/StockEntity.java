package se.iths.charity_shop.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double amount;


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    }

}
