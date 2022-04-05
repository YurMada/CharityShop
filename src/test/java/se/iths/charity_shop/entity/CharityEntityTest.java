package se.iths.charity_shop.entity;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CharityEntityTest {

    @Test
    void ifSetIdShouldReturnSameId() {
        CharityEntity charityEntity = new CharityEntity();
        charityEntity.setId(5L);

        assertThat(charityEntity.getId()).isEqualTo(5L);
    }

    @Test
    void IfSetAmountShouldReturnSameAmount() {
        CharityEntity charityEntity = new CharityEntity();
        charityEntity.setAmount(300);

        assertThat(charityEntity.getAmount()).isEqualTo(300);
    }
}