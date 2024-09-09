package vn.phungquocthai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.phungquocthai.service.UserService;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/home")
    public String getHome() {
        return "home.html";
    }
    
    @RequestMapping(path = {"/", "/hello"})
    public String sayHello(ModelMap modelmap) {
    	String data = userService.handleHello();
    	modelmap.addAttribute("data", data);
    	modelmap.addAttribute("html", "<h1 style=\"color: lime;\">Hack HTML</h1>\r\n");
    	return "hello";
    }
    
    @RequestMapping("admin/user")
    public String getAdmin() {
    	return "admin";
    }
}
