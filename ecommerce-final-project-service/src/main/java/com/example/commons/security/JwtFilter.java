package com.example.commons.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class JwtFilter extends OncePerRequestFilter {

  public static final String JWT_TOKEN = "jwt-token";

  private final JwtTokenProvider tokenProvider;
  private final UserDetailsService userService;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    String token = this.extractToken(request);

    if (this.tokenProvider.isValidToken(token)) {

      String username = this.tokenProvider.getUsernameFromToken(token);

      UserDetails user = this.userService.loadUserByUsername(username);

      Authentication auth = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());

      SecurityContextHolder.getContext().setAuthentication(auth);
    }

    filterChain.doFilter(request, response);
  }

  private String extractToken(HttpServletRequest request) {

    return Optional.ofNullable(request.getCookies()).stream().flatMap(Arrays::stream).filter(cookie -> JWT_TOKEN.equals(cookie.getName()))
        .map(Cookie::getValue).findAny().orElse(null);
  }
}
