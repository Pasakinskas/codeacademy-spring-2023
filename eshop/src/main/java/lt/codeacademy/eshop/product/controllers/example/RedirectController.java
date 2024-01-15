package lt.codeacademy.eshop.product.controllers.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RedirectController {

  @GetMapping("/redirectExample")
  public String getEmptyDtoExampleData(Model model) {
    model.addAttribute("dtoExample", DtoExample.builder().build());

    return "example/redirectForwardExample";
  }

  @PostMapping("/redirectExample")
  public String saveDtoExampleData(Model model, DtoExample dtoExample) {
    // call service etc

    return "redirect:/redirectExample";
  }
}
