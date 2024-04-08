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

// изменить юзера
    @GetMapping(value = "/editUser")
    public String edit(@RequestParam("id") Long id, Model model){
       User user = userService.showUser(id);
        model.addAttribute("editUser", user);
        return "edit";
        }

        //изменить юзера
    @PostMapping(value = "/update")
    public String update(@ModelAttribute("editUser") User user,Long id) {
            userService.update(id, user);
        return "redirect:/";
    }

        @GetMapping(value = "/deleteUser")
        public String delete(@RequestParam("id") Long id, Model model){
            User user = userService.showUser(id);
            userService.delete(id);
            model.addAttribute("deleteUser", user);
            return "redirect:/";
        }
        @PostMapping(value = "/delete")
        public String del(@ModelAttribute("deleteUser") User user,Long id) {
            userService.delete(id);
            return "redirect:/";
        }
}
