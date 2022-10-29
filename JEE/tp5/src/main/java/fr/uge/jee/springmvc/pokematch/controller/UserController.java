package fr.uge.jee.springmvc.pokematch.controller;

import fr.uge.jee.springmvc.pokematch.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

@Controller
@SessionAttributes("member")
public class UserController {


    @ModelAttribute("member")
    public User user() {
        return new User();
    }

    @GetMapping("/authentication")
    public String getForm() { return "authentication";}


    @PostMapping("/authentication")
    public String registerUser(
        @Valid @ModelAttribute User user,
        BindingResult bindingResult,
        Model model,
        @ModelAttribute("member") User member
    ) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(System.out::println);
            model.addAttribute("errorForm", "Veuillez entrer que des lettres");
            return "authentication-error";
        }

        model.addAttribute("user", user);
        return "home";
     }

}
