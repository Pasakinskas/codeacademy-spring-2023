package lt.codeacademy.eshop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FirstController {

  @GetMapping("/hello")
  public String sayHelloToCustomer() {
    return "hello";
  }
}
