package lt.codeacademy.eshop.user.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import lt.codeacademy.eshop.user.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@Slf4j
public class UserController {

  @GetMapping("/create")
  public String getUserForm(Model model) {
    model.addAttribute("userDto", UserDto.builder().build());
    log.info("Got a GET /users/create");

    return "user/user";
  }

  @PostMapping("/create")
  public String register(Model model, @Valid UserDto userDto, BindingResult errors) {
    if (errors.hasErrors()) {
      return "user/user";
    }
    log.info("Got a POST /users/create with {}", userDto);

    return "redirect:/users/create";
  }
}
