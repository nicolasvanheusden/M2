package fr.uge.jee.springmvc.rectanglesession.controller;

import fr.uge.jee.springmvc.rectangle.model.RectangleForm;
import fr.uge.jee.springmvc.rectanglesession.model.RectangleHistory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;


@Controller
@SessionAttributes("rectangleHistory")
public class RectangleSessionController {

    @ModelAttribute("rectangleHistory")
    public RectangleHistory rectangleHistory() {
        return new RectangleHistory();
    }

    @GetMapping("/rectangle-session")
    public String getForm() {
        return "rectangle-session";
    }

    @PostMapping("/rectangle-session")
    public String area(
        @Valid @ModelAttribute RectangleForm rectangleForm,
        BindingResult bindingResult,
        Model model,
        @ModelAttribute("rectangleHistory") RectangleHistory history) {
        var result = 0;
        if (bindingResult.hasErrors()) {
            model.addAttribute("error-form", "Merci d'entrez des numéros valide");
            model.addAttribute("results", history.getResults());
            return "rectangle-session-error";
        }
        result = rectangleForm.getWidth() * rectangleForm.getHeight();
        history.saveResult(result);
        model.addAttribute("results", history.getResults());
        return "rectangle-session";
    }
}
