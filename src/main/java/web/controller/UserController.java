package web.controller;

import dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.UserService;


@Controller
@RequestMapping("/")
public class UserController {
@Autowired
    private UserService userService;



    @GetMapping(value = "/user")
    public String index(Model model){
    model.addAttribute("users", userService.listUsers());
        return "users";
    }


    @GetMapping (value = "/new")
    public String newUser(Model model ){
     model.addAttribute("newUser",new User());


return "new";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute("newUser") User user){
    userService.add(user);
    return "users";
    }

}
