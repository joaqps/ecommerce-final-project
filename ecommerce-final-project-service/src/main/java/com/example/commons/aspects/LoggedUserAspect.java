package com.example.commons.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Aspect
@Component
public class LoggedUserAspect {

  @Pointcut("within(com.example.inbounds.web..*)")
  public void webControllerPointCut() {
  }

  @Before("webControllerPointCut() && args(model)")
  public void beforeWebController(JoinPoint joinPoint, Model model) {

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    if (auth.getPrincipal() instanceof UserDetails) {

      UserDetails user = (UserDetails) auth.getPrincipal();
      model.addAttribute(user);
    }
  }
}
