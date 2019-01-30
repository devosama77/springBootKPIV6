package org.osama.kpi.controllers;

import org.osama.kpi.model.UserInfo;
import org.osama.kpi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Secured({"ROLE_ADMIN"})
    @RequestMapping("users")
    public String getUsers(Model model, @ModelAttribute("user")UserInfo users) {
        List<UserInfo> allUsers = userService.getAllUsers();
        model.addAttribute("users",allUsers);
//                String role="ADMIN";
//        String myRole=role.toString().toUpperCase();
//        List<Role> role1 = roleService.getRole(myRole);
//        model.addAttribute("role",role1);
        return "/pages/users";
    }
    @Secured({"ROLE_ADMIN"})
    @PostMapping(value = "users/add")
    public String addSale(@ModelAttribute("user")UserInfo users, Model model) {
        String password = users.getPassword();
        if(password!=null) {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String encode = bCryptPasswordEncoder.encode(password);
            users.setPassword(encode);
            userService.addUser(users);
        }
        return "redirect:/users";
    }

    @RequestMapping("/users/delete/{name}")
    public String deleteUser(@PathVariable String  name){
        userService.deleteUser(name);
        return "redirect:/users";
    }
}
