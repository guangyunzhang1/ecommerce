package org.ecommerce.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/login")
public class HelloWordAction {

	@RequestMapping(method = RequestMethod.GET)
	public String login() {
		return "account/login";
	}
	
	public static void main(String[] args) {
		System.out.println("ok");
	}
}
