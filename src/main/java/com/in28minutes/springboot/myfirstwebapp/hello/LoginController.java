package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.springboot.myfirstwebapp.login.AuthenticationService;




@Controller
@SessionAttributes("name")
public class LoginController {
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	private AuthenticationService authenticationService;
@RequestMapping(value="login", method=RequestMethod.GET)
	public String gotoLoginPage() {
		return "login";
	}

@RequestMapping(value="login", method=RequestMethod.POST)
public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap  model) {

	if(authenticationService.authenticate(name, password))
	{
		

		model.put("name", name);
		return "welcome";
		
	}
	
	
	model.put("errorMessage", "invalid Credentials");
	
	return "login";
	
}
	
//	@RequestMapping("say-hello-jsp")
	//@ResponseBody REMOVE AS WE DONT WANT TO SEND AN STRING
//	public String sayHellojsp() {
	//	return "sayHello";
//	}
	
	
	
}
