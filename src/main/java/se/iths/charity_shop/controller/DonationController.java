package se.iths.charity_shop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.charity_shop.entity.DonationEntity;
import se.iths.charity_shop.service.DonationService;
import java.util.Optional;

@RestController
@RequestMapping("donations")

public class DonationController {

    DonationService donationService;
    public DonationController(DonationService donationService) {
        this.donationService = donationService;}

    @PostMapping
    public ResponseEntity<DonationEntity> createDonation(@RequestBody DonationEntity donationEntity){
        DonationEntity createdDonation = donationService.createDonation(donationEntity);
        return new ResponseEntity(createdDonation, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public void deleteDonation(@PathVariable Long id){
        donationService.deleteDonation(id);
    }

    @GetMapping("{id}")
    public Optional<DonationEntity> findDonationById(@PathVariable Long id){
        return donationService.findDonationById(id);
    }

    @GetMapping
    public Iterable<DonationEntity> findAll(){
        return donationService.findAll();
    }
}