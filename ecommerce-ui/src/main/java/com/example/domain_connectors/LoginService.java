package com.example.domain_connectors;

import org.springframework.boot.web.server.Cookie;

public interface LoginService {

	Cookie login(String username, String password);
}
