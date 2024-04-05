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



// Все юзеры
@GetMapping(value = "/")
    public String index(Model model){
    model.addAttribute("users", userService.listUsers());
        return "users";
    }

    // добавить юзера
    @GetMapping (value = "/new")
    public String newUser(Model model ){
     model.addAttribute("newUser",new User());
     return "new";
    }
//добавить юзера
    @PostMapping(value = "/create")
    public String create(@ModelAttribute("newUser") User user){
    userService.add(user);
    return "redirect:/";
    }

    @GetMapping(value = "/del")
    public String removeUserById(Model model){
   model.addAttribute("del", new User());
   return "delete";
}
@PostMapping(value = "/delete")
public String removeUserById(@ModelAttribute("del") Long id){
    userService.removeUserById(id);
    return "redirect:/";
}
}
