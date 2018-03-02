package com.naldojesse.group_languages.controllers;
import com.naldojesse.group_languages.models.Language;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GroupLanguages {

    @RequestMapping("/")
    public String index()  {
        return "redirect:/languages";
    }

    @RequestMapping("/languages")
    public String languages(Model model) {
        List<Language> languages = new ArrayList<Language>(Arrays.asList(

        ));


        return "index.jsp";
    }

}
