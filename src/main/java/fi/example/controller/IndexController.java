package fi.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

    @RequestMapping({"/", ""})
    public String index(HttpServletRequest req){
    	if(req.isUserInRole("ADMIN")){
    		
    		return "/admin/lomakejson";	
    	}
    	else if (req.isUserInRole("USER")) {
    		return "/user/kysely";
    	}
    		
        return "login";
    }

    @RequestMapping("/access_denied")
    public String notAuth(){
        return "access_denied";
    }

    @RequestMapping("login")
    public String loginForm(){
        return "login";
    } 
    
    @RequestMapping("/admin/lomakejson")
	public String adminIndex() {
		return "/admin/lomakejson";
	}
    
    @RequestMapping("/user/kysely")
	public String userIndex() {
		return "/user/kysely";
	}
    
}
