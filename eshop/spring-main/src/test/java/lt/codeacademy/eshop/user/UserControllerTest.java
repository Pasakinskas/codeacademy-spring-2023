//package lt.codeacademy.eshop.user;
//
//import lt.codeacademy.security.controller.mvc.UserController;
//import lt.codeacademy.security.dto.UserDto;
//import lt.codeacademy.security.service.UsersRegistrationService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class UserControllerTest {
//
//  @Mock
//  private UsersRegistrationService registrationService;
//  @Mock
//  private Model model;
//  @InjectMocks
//  private UserController userController;
//  @Mock
//  private BindingResult bindingResult;
//
//  @Test
//  void getUserForm_returnsTheUserFormTemplate() {
//    var template = userController.getUserForm(model);
//
//    assertEquals("user/user", template);
//    verify(model).addAttribute(eq("userDto"), any(UserDto.class));
//  }
//
//  @Test
//  void register_callsServiceMethodsToRegisterAUser() {
//    var userDto = UserDto.builder().build();
//
//    when(bindingResult.hasErrors()).thenReturn(false);
//
//    var template = userController.register(model, userDto, bindingResult);
//
//    assertEquals("redirect:/users/create", template);
//    verify(registrationService).register(userDto);
//  }
//
//  @Test
//  void register_getsAnError_itRedirectsBackToUserForm() {
//    var userDto = UserDto.builder().build();
//
//    when(bindingResult.hasErrors()).thenReturn(true);
//
//    var template = userController.register(model, userDto, bindingResult);
//
//    assertEquals("user/user", template);
//    verifyNoInteractions(registrationService);
//  }
//}
