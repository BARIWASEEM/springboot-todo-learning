package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.springboot.myfirstwebapp.login.AuthenticationService;




@Controller
@SessionAttributes("name")
public class WelcomeController {
	
@RequestMapping(value="/", method=RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
	model.put("name",getLoggedinUsername());
		return "welcome";
	}



private String getLoggedinUsername()
{
	
Authentication auth = SecurityContextHolder.getContext().getAuthentication();
return auth.getName();

}



	
}
