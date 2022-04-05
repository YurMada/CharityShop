package se.iths.charity_shop.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class StockEntityTest {


    @Test
    void setIDShouldReturn1L() {
        StockEntity stockEntity = new StockEntity();
        stockEntity.setId(1L);

        assertThat(stockEntity.getId()).isEqualTo(1L);
    }

    @Test
    void getAmountShouldReturn1000(){
        StockEntity stockEntity = new StockEntity();
        stockEntity.setAmount(1000);

        assertThat(stockEntity.getAmount()).isEqualTo(1000);

    }

}