package lt.codeacademy.eshop.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

  @GetMapping
  public String showWelcomePage() {
    return "welcome/welcome";
  }
}
