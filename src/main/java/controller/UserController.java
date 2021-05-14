package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import model.User;
import service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String showAllUsers(ModelMap model) {
        List<User> list = userService.getAllUsers();
        model.addAttribute("allUsers", list);
        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.show(id));
        return "show-user";
    }

    @GetMapping("/new")
    public String addUser(@ModelAttribute("addUser") User user) {
        return "new-user";
    }

    @PostMapping()
    public String addUserBd(@ModelAttribute("addUser") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.show(id));
        return "edit-user";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
