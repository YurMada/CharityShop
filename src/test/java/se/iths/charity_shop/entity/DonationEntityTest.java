package se.iths.charity_shop.entity;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class DonationEntityTest {

    @Test
    void setAmountShouldReturnSameAmount() {
        DonationEntity donationEntity = new DonationEntity();
        donationEntity.setAmount(199);

        assertThat(donationEntity.getAmount()).isEqualTo(199);
    }

    @Test
    void setIdShouldReturnSameID() {

        DonationEntity donationEntity = new DonationEntity();
        donationEntity.setId(9L);

        assertThat(donationEntity.getId()).isEqualTo(9L);
    }
}