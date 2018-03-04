package com.naldojesse.group_languages.repositories;

import com.naldojesse.group_languages.models.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupLanguageRespository extends CrudRepository<Language, Long>{

    List<Language> findAll();

    //default delete method is actually
    //void delete(T entity);
    //this works!
    void deleteById(Long Id);
    Language findOneById(Long Id);

}
