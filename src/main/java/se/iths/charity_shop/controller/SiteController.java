package se.iths.charity_shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import se.iths.charity_shop.entity.CharityEntity;
import se.iths.charity_shop.entity.DonationEntity;
import se.iths.charity_shop.service.CharityService;
import se.iths.charity_shop.service.DonationService;
import se.iths.charity_shop.service.StockService;

import static java.lang.Double.*;

@Controller
public class SiteController {


    private final StockService stockService;
    private final CharityService charityService;
    private final DonationService donationService;

    public SiteController(StockService stockService, CharityService charityService, DonationService donationService) {
        this.stockService = stockService;
        this.charityService = charityService;
        this.donationService = donationService;
    }

    @RequestMapping(value = "/economy", method = RequestMethod.GET)
    public String read(Model model) {
        //double donations = donationService.getTotalAmountDonation();
       // double charities = charityService.getTotalAmountDonation();
       //String economy= String.valueOf(sum(charities,donations));
       // model.addAttribute("currentAmount", (economy));

        double totalAmount = 0;
        Iterable<DonationEntity> donations = donationService.findAll();
        for (var donation : donations)
            totalAmount += donation.getAmount();

        Iterable<CharityEntity> charities = charityService.findAll();
        for (var charity : charities)
            totalAmount -= charity.getAmount();

        model.addAttribute("currentAmount", (totalAmount));
        return "economy";
    }

}
