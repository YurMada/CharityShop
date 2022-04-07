package se.iths.charity_shop.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.iths.charity_shop.entity.UserEntity;

@RestController
@RequestMapping(value = "/javainuse-rabbitmq/")
public class RabbitMQWebController {

    @Autowired
    RabbitMQSender rabbitMQSender;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("empName") String empName, @RequestParam("empId") String empId) {

        UserEntity user=new UserEntity();
        user.setEmail(empId);
        user.setUsername(empName);
        rabbitMQSender.send(user);

        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }

}
