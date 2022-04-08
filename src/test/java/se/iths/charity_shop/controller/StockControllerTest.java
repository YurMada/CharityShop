package se.iths.charity_shop.controller;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import se.iths.charity_shop.entity.StockEntity;
import se.iths.charity_shop.repository.StockRepository;
import se.iths.charity_shop.service.StockService;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    public void createStock_whenPostMethod() {
        StockEntity stock = new StockEntity();
        stock.setAmount(1000.00);
        when(stockRepository.save(ArgumentMatchers.any(StockEntity.class))).thenReturn(stock);

        StockEntity created=stockService.createStock(stock);
        assertThat(created.getAmount()).isSameAs(stock.getAmount());

        verify(stockRepository).save(stock);
    }


}

