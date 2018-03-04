package com.naldojesse.group_languages.services;
import com.naldojesse.group_languages.repositories.GroupLanguageRespository;
import org.springframework.stereotype.Service;
import com.naldojesse.group_languages.models.Language;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class GroupLanguageService {


    private GroupLanguageRespository languageRepository;
    public GroupLanguageService (GroupLanguageRespository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }

    public Optional<Language> findLanguageById(Long id) {
        return languageRepository.findById(id);
    }

    public void addLanguage(Language language) {
        languageRepository.save(language);
    }

    public void updateLanguage(Language language) {
       languageRepository.save(language);
    }

    public void destroyLanguage(Long id) {
        languageRepository.deleteById(id);
    }

}
