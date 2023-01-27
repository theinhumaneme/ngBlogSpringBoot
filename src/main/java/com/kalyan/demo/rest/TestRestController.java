package com.kalyan.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestRestController {
	public TestRestController() {
	}

	@GetMapping("/test")
	public String test() {
		return "Hello API";
	}

}
