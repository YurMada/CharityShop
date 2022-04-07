package se.iths.charity_shop.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.iths.charity_shop.entity.DonationEntity;

@RestController
@RequestMapping(value = "")
public class WebController {

    @Autowired
    Sender rabbitMQSender;

    @GetMapping(value = "/message")
    public String producer(@RequestParam("empName") String amount) {

        DonationEntity donation = new DonationEntity();
        donation.setName(amount);

        rabbitMQSender.send(donation);

        return "New donation was made";
    }
}
