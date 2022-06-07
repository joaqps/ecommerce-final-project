package com.example.domain_connectors;

import javax.servlet.http.Cookie;

public interface LoginService {

	Cookie login(String username, String password);
}
