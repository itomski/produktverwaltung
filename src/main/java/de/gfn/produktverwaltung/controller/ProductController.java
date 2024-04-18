package de.gfn.produktverwaltung.controller;

import de.gfn.produktverwaltung.model.Product;
import de.gfn.produktverwaltung.model.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {

    /* Mappings
    | METHODE   | URL           | Controller            | Action        |
    | GET       | /             | ProductController     | start()       |
    | GET       | /produkte     | ProductController     | list()    |
    | GET       | /erfassung     | ProductController    | form()    |
     */

    // Model wird benötigt um Informationen/Daten aus der Controller-Methode
    // an die Templates zu schicken

    @Autowired // Ein Objekt von ProductRepository wird von Spring hier eingesetzt
    private ProductRepository repo;


    @GetMapping
    public String start(Model ui) {
        ui.addAttribute("greeting", "Hallo Spring");
        return "start"; // Name des Templates ohne Endung .html
    }

    @GetMapping("/produkte")
    public String list(Model ui) {
        ui.addAttribute("title", "Produktübersicht");
        ui.addAttribute("products", repo.findAll());
        return "list"; // list.html
    }

    @GetMapping("/erfassung")
    public String form(Model ui) {
        ui.addAttribute("title", "Produkterfassung");
        ui.addAttribute("product", new Product());
        return "form"; // form.html
    }

    @PostMapping("/speichern")
    public String save(@Valid Product product, BindingResult result, Model ui) {

        if(result.hasErrors()) {
            return "form";
        }
        repo.save(product);
        return "redirect:/produkte"; // Umleitung auf die list-Methode
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable UUID id, Model ui) {
        Product product = repo.findById(id).orElse(new Product());
        ui.addAttribute("title", "Produkt bearbeiten");
        ui.addAttribute("product", product); // Gefundenes
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable UUID id, Model ui) { // @PathVariable id wird aus der URL ausgelesen
        // TODO: Prüfen, ob id verfügbar
        repo.deleteById(id);
        return "redirect:/produkte";
    }
}
