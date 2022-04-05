package se.iths.charity_shop.controller;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import se.iths.charity_shop.entity.StockEntity;
import se.iths.charity_shop.repository.StockRepository;
import se.iths.charity_shop.service.StockService;

import static groovy.json.JsonOutput.toJson;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Ignore
@RunWith(SpringRunner.class)
@WebMvcTest(StockController.class)
public class StockControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    StockRepository stockRepository;
    @InjectMocks
    StockService stockService;
   @Test
    public void createStock_whenPostMethod() throws Exception {
        StockEntity stock = new StockEntity();
        stock.setAmount(1000.00);
        when(stockRepository.save(ArgumentMatchers.any(StockEntity.class))).thenReturn(stock);

        StockEntity created=stockService.createStock(stock);
        assertThat(created.getAmount()).isSameAs(stock.getAmount());

        verify(stockRepository).save(stock);
    }
}

