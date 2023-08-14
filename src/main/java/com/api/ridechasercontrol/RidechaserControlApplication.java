package com.api.ridechasercontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RidechaserControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(RidechaserControlApplication.class, args);
	}

	@GetMapping("/")
	public String index(){
		return "This is a control for spots in a base";
	}

}
