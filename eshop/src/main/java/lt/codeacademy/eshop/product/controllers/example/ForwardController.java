package lt.codeacademy.eshop.product.controllers.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ForwardController {

  @GetMapping("/forwardExample")
  public String getEmptyDtoExampleData(Model model) {
    model.addAttribute("dtoExample", DtoExample.builder().build());

    return "example/redirectForwardExample";
  }

  @PostMapping("/forwardExample")
  public String saveDtoExampleData(Model model, DtoExample dtoExample) {
    // call service etc

    return "forward:/secondForwardPage";
  }

  @PostMapping("/secondForwardPage")
  public String secondForwardPage(Model model, DtoExample dtoExample) {
    // call service etc

    return "welcome/welcome";
  }
}
