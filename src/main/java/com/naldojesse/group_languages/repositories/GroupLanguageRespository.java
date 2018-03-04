package com.naldojesse.group_languages.repositories;

import com.naldojesse.group_languages.models.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupLanguageRespository extends CrudRepository<Language, Long>{
    List<Language> findAll();
}
