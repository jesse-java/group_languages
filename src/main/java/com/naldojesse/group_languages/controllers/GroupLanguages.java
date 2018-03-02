package com.naldojesse.group_languages.controllers;

import com.naldojesse.group_languages.models.Language;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import com.naldojesse.group_languages.services.GroupLanguageService;

import javax.validation.Valid;
import java.util.List;

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
    public String findLanguageByIndex(Model model, @PathVariable("index") int index) {
        Language language = languageService.findLanguageByIndex(index);
        model.addAttribute("language", language);
        return "view.jsp";
    }

    @RequestMapping("/languages/new")
    public String createLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "languages.jsp";
        } else {
            languageService.addLanguage(language);
            return "redirect:/languages";
        }
    }

}
