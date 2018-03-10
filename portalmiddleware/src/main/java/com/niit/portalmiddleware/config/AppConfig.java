package com.niit.portalmiddleware.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@Configuration
@ComponentScan("com.niit")
@EnableWebMvc
public class AppConfig {

}

