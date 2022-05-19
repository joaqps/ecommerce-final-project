package com.example.inbounds.web;

import com.example.domain_connectors.LoginService;
import com.example.domain_connectors.UserService;
import com.example.inbounds.web.dtos.AlertDTO;
import com.example.inbounds.web.dtos.LoginRequestDTO;
import com.example.inbounds.web.dtos.LoginResponseDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class LoginWebController {

  private final Logger logger = LoggerFactory.getLogger(LoginWebController.class);

  private final UserService userService;
  private final LoginService loginService;

  @GetMapping("/login")
  public String getLoginPage(Model model) {
    return "login";
  }

  @GetMapping("/register")
  public String getRegisterPage(Model model) {
    return "register";
  }

  @GetMapping("/login-success")
  public String getLoginSuccessPage(Model model, RedirectAttributes attributes) {

    attributes.addFlashAttribute("alerts", List.of(new AlertDTO("success", "User was logged in successfully.")));
    return "redirect:/ecommerce/brands";
  }

  @PostMapping(value = "/register", produces = "application/json")
  @ResponseBody
  public ResponseEntity<LoginResponseDTO> register(@RequestBody LoginRequestDTO loginRequest) {

    try {
      userService.saveUser(loginRequest.getUsername(), loginRequest.getPassword());
    } catch (DuplicateKeyException ex) {
      return ResponseEntity.ok(new LoginResponseDTO(false, "Username already exists."));
    }

    return ResponseEntity.ok(new LoginResponseDTO(true, "User was registered successfully."));
  }

  @PostMapping(value = "/login")
  public ResponseEntity<LoginResponseDTO> login(HttpServletResponse response, @RequestParam String username,
      @RequestParam String password) {

    try {
      Cookie loginCookie = loginService.login(username, password);
      response.addCookie(loginCookie);
    } catch (BadCredentialsException ex) {
      return ResponseEntity.ok(new LoginResponseDTO(false, "Incorrect username or password."));
    }

    return ResponseEntity.ok(new LoginResponseDTO(true, "Login successful."));
  }
}
