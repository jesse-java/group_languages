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

    public Language findLanguageByIndex(int index) {
        if (index < languages.size()) {
            return languages.get(index);
        } else {
            return null;
        }
    }

    public void addLanguage(Language language) {
        languages.add(language);
    }

    public void updateLanguage(int id, Language language) {
        if (id < languages.size()) {
            languages.set(id, language);
        }
    }

    public void destroyLanguage(int id) {
        if (id < languages.size()) {
            languages.remove(id);
        }
    }

}
