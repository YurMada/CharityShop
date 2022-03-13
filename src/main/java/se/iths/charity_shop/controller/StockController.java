package se.iths.charity_shop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.charity_shop.entity.StockEntity;
import se.iths.charity_shop.service.StockService;
import java.util.Optional;

@RestController
@RequestMapping("stocks")

public class StockController {

    StockService stockService;
    public StockController(StockService stockService){
        this.stockService = stockService;}

    @PostMapping
    public ResponseEntity<StockEntity> createStock(@RequestBody StockEntity stockEntity){
        StockEntity createdStock = stockService.createStock(stockEntity);
        return new ResponseEntity(createdStock, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public void deleteStock(@PathVariable Long id){
        stockService.deleteStock(id);
    }

    @GetMapping("{id}")
    public Optional<StockEntity> findStockById(@PathVariable Long id){
        return stockService.findStockById(id);
    }

    @GetMapping
    public Iterable<StockEntity> findAll(){
        return stockService.findAll();
    }
}
