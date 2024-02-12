//package lt.codeacademy.eshop.user;
//
//import lt.codeacademy.eshop.common.user.registration.service.UsersRegistrationService;
//import lt.codeacademy.security.core.controller.UserController;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//
//@WebMvcTest(controllers = UserController.class)
//@ExtendWith(MockitoExtension.class)
//@AutoConfigureMockMvc(addFilters = false)
//public class UserControllerIT {
//
//  @Autowired
//  private MockMvc mockMvc;
//
//  @MockBean
//  private UsersRegistrationService registrationService;
//
//  @Test
//  void getUserForm_shouldDisplayUserForm() throws Exception {
//    mockMvc.perform(get("/users/create"))
//      .andExpect(status().isOk())
//      .andExpect(view().name("user/user"))
//      .andExpect(model().attributeExists("userDto"));
//  }
//
///*  @Test
//  void register_shouldCreateAUser() throws Exception {
//    var userDto = UserDto.builder()
//        .name("Marius")
//        .surname("Pasakinskas")
//        .email("email@mail.com")
//        .password("password123")
//        .repeatPassword("password123")
//        .zipCode("12345")
//        .phoneNumber("+37061231212")
//        .build();
//
//    mockMvc.perform(
//      post("/users/create")
//        .param("name", userDto.getName())
//        .param("surname", userDto.getSurname())
//        .param("email", userDto.getEmail())
//        .param("password", userDto.getPassword())
//        .param("repeatPassword", userDto.getRepeatPassword())
//        .param("zipCode", userDto.getZipCode())
//        .param("phoneNumber", userDto.getPhoneNumber())
//      )
//      .andExpect(status().is3xxRedirection())
//      .andExpect(model().hasNoErrors())
//      .andExpect(view().name("redirect:/users/create"));
//
//
//    verify(registrationService).register(any(UserDto.class));
//  }
//
//  @Test
//  void register_getBadParameters_doesNotRegisterUser() throws Exception {
//    var userDto = UserDto.builder()
//      .name("Marius")
//      .surname("Pasakinskas")
//      .email("email@mail.com")
//      .password("password123")
//      .repeatPassword("password123")
//      .zipCode("12345")
//      .build();
//
//    mockMvc.perform(
//        post("/users/create")
//          .param("name", userDto.getName())
//          .param("surname", userDto.getSurname())
//          .param("email", userDto.getEmail())
//          .param("password", userDto.getPassword())
//          .param("repeatPassword", userDto.getRepeatPassword())
//          .param("zipCode", userDto.getZipCode())
//          .param("phoneNumber", userDto.getPhoneNumber())
//      )
//      .andExpect(status().isOk())
//      .andExpect(model().hasErrors())
//      .andExpect(view().name("user/user"));
//
//
//    verifyNoInteractions(registrationService);
//  }*/
//}
