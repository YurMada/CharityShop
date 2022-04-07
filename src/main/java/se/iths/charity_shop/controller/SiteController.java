package se.iths.charity_shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import se.iths.charity_shop.service.CharityService;
import se.iths.charity_shop.service.DonationService;
import se.iths.charity_shop.service.StockService;

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
        int donations = donationService.getTotalAmountDonation();
        int charities = charityService.getTotalAmountDonation();
        int balance = donations-charities;
        String economy= String.valueOf(balance);
        model.addAttribute("currentAmount", (economy));
        return "economy";
    }

}
