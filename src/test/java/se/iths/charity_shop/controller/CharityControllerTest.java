package se.iths.charity_shop.controller;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import se.iths.charity_shop.entity.CharityEntity;
import se.iths.charity_shop.repository.CharityRepository;
import se.iths.charity_shop.service.CharityService;
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
@WebMvcTest(CharityController.class)
class CharityControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Mock
    CharityRepository charityRepository;
    @InjectMocks
    CharityService charityService;

    @Test
    void createCharityWhenPostMethod() {

        CharityEntity charity = new CharityEntity();
        charity.setAmount(50);
        when(charityRepository.save(any(CharityEntity.class))).thenReturn(charity);
        CharityEntity charity1 =charityService.createCharity(charity);
        assertThat(charity1.getAmount()).isSameAs(charity.getAmount());
        verify(charityRepository).save(charity);

    }

    @Test
    void getAllCharitiesReturnsEmptyList() throws Exception {
        when(charityRepository.findAll()).thenReturn(List.of());
        mockMvc.perform(get("/charities").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    void getCharityByIdShouldReturnError() throws Exception {

        Long id = 5L;
        when(charityRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        mockMvc.perform(get("charities/{id}", id).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("path").value("/charities/" + id))
                .andExpect(jsonPath("message").value("charity with ID " + id + " not found."));
    }
}