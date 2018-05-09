package com.philspelman.springgrouplanguages.controllers;

import com.philspelman.springgrouplanguages.models.Language;
import com.philspelman.springgrouplanguages.services.LanguageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class Languages {


    private final LanguageService languageService;
    public Languages(LanguageService languageService) {
        this.languageService = languageService;}

    @RequestMapping("/languages")
    public String languages(Model model) {
        List<Language> languages = languageService.allLanguages();

        model.addAttribute("languages", languages);
        return "languages";
    }




    @RequestMapping("/languages/new")
    public String newLanguage(@ModelAttribute("language") Language language) {
        return "lang_form";
    }


////    public String newLanguage(@Valid Language language, BindingResult bindingResult) {

//    @RequestMapping("/createLang")
//    public String newLanguageProcessor(Language language) {
//        System.out.println(language);
//
//        return "redirect: /languages";
//    }
    @RequestMapping("/createLang")
    public String newLanguageProcessor(@Valid Language language, BindingResult br) {
        if (br.hasErrors()) {
            System.out.println("got some errors!");
            return "lang_form";
        } else {
            System.out.println(language);
            return "redirect: /languages";
        }

    }
//


}


//    public String languages(Model model) {
//
//
//        System.out.println("getting the languages page");
//
//        return "lang_form";
////        return "languages";
//    }
//}
