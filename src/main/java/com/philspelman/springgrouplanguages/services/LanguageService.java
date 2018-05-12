package com.philspelman.springgrouplanguages.services;

import com.philspelman.springgrouplanguages.models.Language;
import com.philspelman.springgrouplanguages.repositories.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {

    //DONE: make the LanguageRepository
    private LanguageRepository languageRepository;

    //DONE: Initialize the languageRepository (comes from the LanguageService
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }


    private List<Language> languages = new ArrayList<>(Arrays.asList(
            new Language("Java", "Mr java", "1.2.3"),
            new Language("Ruby", "Ms Tuesday", "3.0.99"),
            new Language("Python", "Mr python", "1234.4321")
    ));


    //todo: update the allLanguages() function to return allLanguages from the repository

    public List<Language> allLanguages() {

        return languageRepository.findAll();

//        return this.languages;
    }



    // add a new language
    public void addLanguage(Language language) {
        System.out.println("trying to add a new language");

        //fixme: use the languageRepository to .save(language)
        languageRepository.save(language);

//        languages.add(language);
    }

    //get language
    public Language findLanguageById(Long id) {
        System.out.println("LanguageService says: Finding language by ID");
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if (optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }


//    public Language findLanguageByIndex(int id) {
//        if (id < languages.size()) {
//            return languages.get(id);
//        } else {
//            System.out.println("Language not in list");
//            return null;
//        }
//    }
//
    //edit language
    public void updateLanguage(Language language) {
        languageRepository.save(language);
    }

//    //NODB - edit language
//    public void updateLanguage(int id, Language language) {
//        if (id < languages.size()) {
//            System.out.println("trying to update the language");
//            languages.set(id, language);
//        } else {
//            System.out.println("language not in list");
//
//        }
//    }
//

    //delete language
    public void destroyLanguage(Long id) {
        languageRepository.deleteById(id);
    }

//    //NODB - delete language
//    public void destroyLanguage(int id) {
//        if (id < languages.size()) {
//            System.out.println("Trying to remove that language");
//            languages.remove(id);
//        } else {
//            System.out.println("Language not in list");
//
//        }
//    }
//


}
