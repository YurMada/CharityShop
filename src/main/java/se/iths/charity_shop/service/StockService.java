package se.iths.charity_shop.service;

import org.springframework.stereotype.Service;
import se.iths.charity_shop.entity.StockEntity;
import se.iths.charity_shop.repository.StockRepository;
import java.util.Optional;

@Service
public class StockService {


    StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {this.stockRepository = stockRepository;}

    public StockEntity createStock(StockEntity stockEntity) {return stockRepository.save(stockEntity);}

    public void deleteStock(Long id) {
        Optional<StockEntity> foundStock = stockRepository.findById(id);
        stockRepository.deleteById(id);
    }

    public Optional<StockEntity> findStockById(Long id) {return stockRepository.findById(id);}

    public Iterable<StockEntity> findAll() {return stockRepository.findAll();}
}
