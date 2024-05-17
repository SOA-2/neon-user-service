package com.cinemas.neon.neonuserservice.service;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.AbstractFormWriter;
import org.springframework.cloud.openfeign.support.JsonFormWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cinemas.neon.neonuserservice.bean.LoginConversion;

@FeignClient(value = "keycloak", url = "http://localhost:9090", configuration = KeycloakProxy.Configuration.class)
public interface KeycloakProxy {

    @RequestMapping(method = RequestMethod.POST, value = "/realms/neon/protocol/openid-connect/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    LoginConversion logIn(@RequestBody Map<String, ?> form);

    class Configuration {
        @Bean
        public AbstractFormWriter jsonFormWriter() {
            return new JsonFormWriter();
        }
    }
}
