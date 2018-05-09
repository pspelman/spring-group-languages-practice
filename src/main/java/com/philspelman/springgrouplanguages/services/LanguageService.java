package com.philspelman.springgrouplanguages.services;

import com.philspelman.springgrouplanguages.models.Language;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LanguageService {

    private List<Language> languages = new ArrayList<>(Arrays.asList(
            new Language("Java", "Mr java", "1.2.3")
    ));

    public List<Language> allLanguages() {
        return this.languages;
    }
}
