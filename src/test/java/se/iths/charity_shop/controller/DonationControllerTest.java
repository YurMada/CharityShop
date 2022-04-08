package se.iths.charity_shop.controller;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import se.iths.charity_shop.entity.DonationEntity;
import se.iths.charity_shop.repository.DonationRepository;
import se.iths.charity_shop.service.DonationService;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Ignore
@RunWith(SpringRunner.class)
@WebMvcTest(DonationController.class)
class DonationControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Mock
    DonationRepository donationRepository;
    @InjectMocks
    DonationService donationService;

    @Test
    void createDonationWhenPostMethod() {

        DonationEntity donation = new DonationEntity();
        donation.setAmount(50);
        donation.setName("RedCross");
        when(donationRepository.save(ArgumentMatchers.any(DonationEntity.class))).thenReturn(donation);
        DonationEntity donation1 = donationService.createDonation(donation);
        assertThat(donation1.getAmount()).isSameAs(donation.getAmount());
        assertThat(donation1.getName()).isSameAs(donation.getName());
        verify(donationRepository).save(donation);

    }

    @Test
    void getAllDonationsReturnsEmptyList() throws Exception {

        when(donationRepository.findAll()).thenReturn(List.of());
        mockMvc.perform(MockMvcRequestBuilders.get("/donations").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    void getDonationByIdShouldReturnError() throws Exception {

        Long id = 10L;
        when(donationRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        mockMvc.perform(get("donations/{id}", id).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("path").value("/donations/" + id))
                .andExpect(jsonPath("message").value("donation with ID " + id + " not found."));
    }
}