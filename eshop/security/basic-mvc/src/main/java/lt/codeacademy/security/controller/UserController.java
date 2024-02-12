package lt.codeacademy.security.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lt.codeacademy.security.core.registration.dto.UserRegistrationDto;
import lt.codeacademy.security.core.registration.service.UserCreateService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

  private final UserCreateService userRegistrationService;

  @GetMapping("/create")
  public String getUserForm(Model model) {
    model.addAttribute("userDto", UserRegistrationDto.builder().build());
    log.info("Got a GET /users/create");

    return "user/user";
  }

  @PostMapping("/create")
  public String register(Model model, @Valid UserRegistrationDto userRegistrationDto, BindingResult errors) {
    if (errors.hasErrors()) {
      return "user/user";
    }
    try {
      userRegistrationService.createUser(userRegistrationDto);
    } catch (DataIntegrityViolationException e) {
      if (e.getMessage().contains("EMAIL")) {
        //TODO: pasiaskinti kodel nerodo klaidos html'e
        errors.rejectValue("email", "Email already used!");
      }
    }

    return "redirect:/users/create";
  }
}
