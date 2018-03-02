package com.naldojesse.group_languages.services;
import org.springframework.stereotype.Service;
import com.naldojesse.group_languages.models.Language;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GroupLanguageService {

    //initialize languages variable with values
    private List<Language> languages = new ArrayList<>(Arrays.asList(
            new Language("Java", "Mark Doubtfire", "1.2"),
            new Language("Python", "Snake Slytherin", "3.5"),
            new Language("Ruby", "Ash Kethum", "1.0")
            ));

    //returns all the languages
    public List<Language> allLanguages() {
        return languages;
    }
}
