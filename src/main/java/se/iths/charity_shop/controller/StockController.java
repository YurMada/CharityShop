package se.iths.charity_shop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import se.iths.charity_shop.entity.StockEntity;
import se.iths.charity_shop.exception.BadRequestException;
import se.iths.charity_shop.service.StockService;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("stocks")

public class StockController {

    StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<StockEntity> createStock(@RequestBody StockEntity stockEntity) {
        if (stockEntity == null)
            throw new BadRequestException("This field cannot be empty");
        StockEntity createdStock = stockService.createStock(stockEntity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("stocks")
                .buildAndExpand(createdStock.getId())
                .toUri();
        return ResponseEntity.created(uri).body(createdStock);
    }

    @DeleteMapping("{id}")
    public void deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
    }

    @GetMapping("{id}")
    public Optional<StockEntity> findStockById(@PathVariable Long id) {
        return stockService.findStockById(id);
    }

    @GetMapping
    public Iterable<StockEntity> findAll() {
        return stockService.findAll();
    }
}

