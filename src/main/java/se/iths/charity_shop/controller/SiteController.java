package se.iths.charity_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import se.iths.charity_shop.entity.StockEntity;
import se.iths.charity_shop.service.StockService;

@Controller
public class SiteController {



    @Autowired
    StockService stockService;

    @RequestMapping(value = "/economy", method = RequestMethod.GET)
    public String read(Model model) {
        Iterable<StockEntity> names = stockService.findAll();
        Double totalAmount=0.00;
        for (var name : names) {
            totalAmount += name.getAmount();
        }
        model.addAttribute("name", totalAmount);
        return "economy";
    }
}
