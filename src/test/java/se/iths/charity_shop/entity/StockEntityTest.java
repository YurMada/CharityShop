package se.iths.charity_shop.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StockEntityTest {


    @Test
    void setIDShouldReturn1L() {
        StockEntity stockEntity = new StockEntity();
        stockEntity.setId(1L);

        assertThat(stockEntity.getId()).isEqualTo(1L);
    }

}