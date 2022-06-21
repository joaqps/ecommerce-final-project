package com.example.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "keycloak.server")
@Data
public class KeycloakServerProperties {

    String contextPath = "/auth";
    String realmImportFile = "ecommerce-realm.json";
    AdminUser adminUser = new AdminUser();

    @Data
    public static class AdminUser {
        String username = "admin";
        String password = "admin";
    }
}
