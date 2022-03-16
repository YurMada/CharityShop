package se.iths.charity_shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.charity_shop.entity.CharityEntity;
import se.iths.charity_shop.exception.BadRequestException;
import se.iths.charity_shop.service.CharityService;
import java.util.Optional;

@RestController
@RequestMapping("charities")

public class CharityController {

    CharityService charityService;
    public CharityController(CharityService charityService){
        this.charityService = charityService;}

    @PostMapping
    public ResponseEntity<CharityEntity> createCharity(@RequestBody CharityEntity charityEntity){
        if (charityEntity == null)
            throw new BadRequestException("This field cannot be empty");

        CharityEntity createdCharity = charityService.createCharity(charityEntity);
        return new ResponseEntity(createdCharity, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public void deleteCharity(@PathVariable Long id){
        charityService.deleteCharity(id);
    }


    @GetMapping("{id}")
    public Optional<CharityEntity> findCharityById(@PathVariable Long id){
        return charityService.findCharityById(id);

    }

    @GetMapping
    public Iterable<CharityEntity> findAll(){
        return charityService.findAll();

    }
}

