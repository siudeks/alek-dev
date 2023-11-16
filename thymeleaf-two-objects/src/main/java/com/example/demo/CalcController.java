package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class CalcController {

    @GetMapping("/")
    public String main(Model model) {
        var person = new Person();
        person.setFirstName("Aleksander");
        var pet = new Pet();
        pet.setName("kroliczek");
        model.addAttribute("project", new Project());
        model.addAttribute("pet", pet);
        model.addAttribute("person", person);

        return "result"; // view
    }

}
