package fr.uge.jee.springmvc.rectanglesession.controller;

import fr.uge.jee.springmvc.rectangle.model.RectangleForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class RectangleSessionController {

    private final ArrayList<Integer> results;

    public RectangleSessionController() {
        this.results = new ArrayList<>();
    }

    @GetMapping("/rectangle-session")
    public String getForm() {
        return "rectangle-session";
    }

    @PostMapping("/rectangle-session")
    public String area(@Valid RectangleForm rectangleForm, BindingResult bindingResult, Model model) {
        var result = 0;
        if (bindingResult.hasErrors()) {
            model.addAttribute("error-form", "Merci d'entrez des numéros valide");
            model.addAttribute("results", results);
            return "rectangle-session-error";
        }
        result = rectangleForm.getWidth() * rectangleForm.getHeight();
        results.add(result);
        model.addAttribute("results", results);
        return "rectangle-session";
    }
}
