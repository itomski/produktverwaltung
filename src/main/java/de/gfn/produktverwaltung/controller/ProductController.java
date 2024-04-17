package de.gfn.produktverwaltung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    /* Mappings
    | METHODE   | URL           | Controller            | Action        |
    | GET       | /             | ProductController     | start()       |
    | GET       | /products     | ProductController     | products()    |
     */


    @GetMapping
    public String start(Model ui) {
        ui.addAttribute("greeting", "Hallo Spring");
        return "start"; // Name des Templates ohne Endung .html
    }
}
