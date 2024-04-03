package web.controller;

import dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class UserController {

    private UserDao userDao;
@Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(value = "/user")
    public String index(Model model){
    model.addAttribute("users", userDao.listUsers());
        return "users";
    }
@GetMapping(value = "new")
    public String newUser(Model model){
    model.addAttribute("newUser", new User());
return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("users") User user){
    userDao.add(user);
    return "redirect:/users";
    }

}
