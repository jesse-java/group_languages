package com.naldojesse.group_languages.controllers;

import com.naldojesse.group_languages.models.Language;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import com.naldojesse.group_languages.services.GroupLanguageService;

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
    public String languages(Model model) {
        List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        return "languages.jsp";
    }



}
