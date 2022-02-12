package org.universal.studentmanagement.stucontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralController {

	@GetMapping("/")
	public String welcomeMessage() {
		return "Welcome for the demo";
	}

}
