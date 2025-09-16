package com.neves.status.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/blackbox")
public class BlackboxController {
	public static class Dto {
		public String name;
		public int age;
	}
	@GetMapping("/test")
	public String test(@RequestParam Dto dto) {
		return "Hello " + dto.name + ", you are " + dto.age + " years old!";
	}

}
