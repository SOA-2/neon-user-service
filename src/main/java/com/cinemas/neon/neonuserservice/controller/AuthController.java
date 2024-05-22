package com.cinemas.neon.neonuserservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cinemas.neon.neonuserservice.bean.LoginConversion;
import com.cinemas.neon.neonuserservice.service.KeycloakProxy;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private KeycloakProxy keycloakProxy;

    @PostMapping(path = "", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    public LoginConversion convertCurrencyFeign(@RequestParam String client_id, @RequestParam String username, @RequestParam String password, @RequestParam String grant_type) {
        Map<String, String> formData = new HashMap<String, String>();
        formData.put("client_id", client_id);
        formData.put("username", username);
        formData.put("password", password);
        formData.put("grant_type", grant_type);
        return keycloakProxy.logIn(formData);
    }
}
