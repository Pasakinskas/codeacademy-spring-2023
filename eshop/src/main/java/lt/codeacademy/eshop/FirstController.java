package lt.codeacademy.eshop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FirstController {

  @GetMapping("/hello/{name}")
  public String sayHelloToCustomer(@PathVariable String name, @RequestParam String surname) {
    System.out.println("Hello, my name is " + name + " " + surname);
    return "hello";
  }
}
