package com.in28minutes.springboot.microservice.example.currencyconversion.springbootmicroservicezuul;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@RefreshScope
public class SpringBootMicroserviceZuulApplication {

	@Value("${user.role}")
	private String role;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroserviceZuulApplication.class, args);
	}

	@GetMapping(
		value="whoami/{username}",
		produces= MediaType.TEXT_PLAIN_VALUE)
	public String whoami(@PathVariable("username") String username) {
		return String.format("Hello! You're %s and you'll become a(n) %s...\n", username, role);
	}

}
