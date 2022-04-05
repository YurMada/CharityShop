package se.iths.charity_shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.iths.charity_shop.entity.RoleEntity;
import se.iths.charity_shop.entity.StockEntity;
import se.iths.charity_shop.repository.CharityRepository;
import se.iths.charity_shop.repository.DonationRepository;
import se.iths.charity_shop.repository.StockRepository;
import java.util.Optional;

@Service
public class StockService {

    private final CharityRepository charityRepository;
    private final DonationRepository donationRepository;

    @Autowired
    StockRepository stockRepository;

    public StockService(CharityRepository charityRepository, DonationRepository donationRepository, StockRepository stockRepository) {
        this.charityRepository = charityRepository;
        this.donationRepository = donationRepository;
        this.stockRepository = stockRepository;
    }

    public StockEntity createStock(StockEntity stockEntity) {
        charityRepository.findAll();
        stockRepository.findAll();
    return stockRepository.save(stockEntity);}


    public void saveOrUpdate(StockEntity stockEntity)
    {
        stockRepository.save(stockEntity);
    }

    public void deleteStock(Long id) {
        Optional<StockEntity> foundStock = stockRepository.findById(id);
        stockRepository.deleteById(id);
    }

    public Optional<StockEntity> findStockById(Long id) {return stockRepository.findById(id);}

    public Iterable<StockEntity> findAll() {return stockRepository.findAll();}
}
