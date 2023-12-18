package org.launchcode.munchincrunch.controllers;

import jakarta.validation.Valid;
import org.launchcode.munchincrunch.data.CategoryRepository;
import org.launchcode.munchincrunch.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddCategoriesController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public String displayAllCategories(Model model) {
        model.addAttribute("title", "All Categories");
        model.addAttribute("categories", categoryRepository.findAll());
        return "categories/index"; //insert API data for categories?
    }

    @GetMapping("create")
    public String renderCreateCategoryForm(Model model) {
        model.addAttribute("title", "Create Category");
        model.addAttribute(new Category());
        return "categories/create";
    }

    @PostMapping("create")
    public String processCreateCategoryForm(@Valid @ModelAttribute Category category, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Category");
            model.addAttribute(new Category());
            return "categories/create";
        }
        categoryRepository.save(Category);
        return "redirect:/categories";
    }




}
