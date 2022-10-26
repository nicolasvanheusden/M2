package fr.uge.jee.springmvc.pokematch.controller;

import fr.uge.jee.springmvc.pokematch.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

@Controller
@SessionAttributes("user")
public class UserController {


    @ModelAttribute("user")
    public User user() {
        return new User();
    }


    @PostMapping("/authentication")
    public String registerUser( @Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error-form", "Merci d'entrez que des lettres");
            return "authentication-error";
        }

        model.addAttribute("user", user);
        return "home";
     }

}
