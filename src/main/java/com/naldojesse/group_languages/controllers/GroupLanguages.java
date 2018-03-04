package com.naldojesse.group_languages.controllers;

import com.naldojesse.group_languages.models.Language;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import com.naldojesse.group_languages.services.GroupLanguageService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class GroupLanguages {

    private final GroupLanguageService languageService;
    public GroupLanguages(GroupLanguageService languageService) {
        this.languageService = languageService;
    }


    @RequestMapping("/")
    public String index()  {
        return "redirect:/languages";
    }

    @RequestMapping("/languages")
    public String languages(@ModelAttribute("language") Language language, Model model) {
        List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        return "languages.jsp";
    }

    @RequestMapping("/languages/{index}")
    public String findLanguageByIndex(Model model, @PathVariable("index") Long index) {
        Optional<Language> language = languageService.findLanguageById(index);
//        System.out.println(language);
        if (language.isPresent()) {
            model.addAttribute("language", language.get());
        } else {
            return "redirect:/languages";
        }
        return "view.jsp";
    }

    @PostMapping("/languages/new")
    public String createLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "languages.jsp";
        } else {
            languageService.addLanguage(language);
            return "redirect:/languages";
        }
    }

    @RequestMapping("/languages/edit/{id}")
    public String editLanguage(@PathVariable("id") Long index, Model model) {
        Optional<Language> language = languageService.findLanguageById(index);
        if (language.isPresent()) {
            model.addAttribute("language", language.get());
            return "edit.jsp";
        } else {
            return "redirect:/languages";
        }
    }

    @PostMapping("/languages/edit/{id}")
    public String updateLanguage(@PathVariable("id") Long id, @Valid @ModelAttribute("language") Language language, BindingResult result) {
        System.out.println(result.hasErrors());
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            languageService.updateLanguage(language);
            return "redirect:/languages/" + id;
        }

    }

    @RequestMapping("/languages/delete/{id}")
    public String deleteLanguage(@PathVariable("id") Long id) {
        languageService.destroyLanguage(id);
        return "redirect:/";
    }

}
