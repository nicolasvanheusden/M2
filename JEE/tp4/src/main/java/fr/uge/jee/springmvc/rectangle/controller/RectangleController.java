package fr.uge.jee.springmvc.rectangle.controller;


import fr.uge.jee.springmvc.rectangle.model.RectangleForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RectangleController {

    @GetMapping("/rectangle")
    public String getForm() {
        return "rectangle";
    }

    @PostMapping("/rectangle")
    public String area(@Valid RectangleForm rectangleForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error-form", "Merci d'entrez des numéros valide");
            return "rectangle-error";
        }
        model.addAttribute("area", rectangleForm.getWidth() * rectangleForm.getHeight());
        return "rectangle-area";
    }
}
