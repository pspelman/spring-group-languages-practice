package com.philspelman.springgrouplanguages.controllers;

import com.philspelman.springgrouplanguages.models.Language;
import com.philspelman.springgrouplanguages.services.LanguageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class Languages {

    //bring in connection to data manager (LanguageService)
    private final LanguageService languageService;
    public Languages(LanguageService languageService) {

        this.languageService = languageService;}


    @RequestMapping("/languages")
    public String languages(Model model) {
        System.out.println("reached the /languages route...getting the languages");

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

    //todo: EDIT language
    @RequestMapping("/languages/edit/{id}")
    public String edit(@PathVariable("id") int edit_language_id, Model model) {
        System.out.println("reached EDIT language route...tring to edit language: " + edit_language_id);

        Language language = languageService.findLanguageByIndex(edit_language_id);

        model.addAttribute("edit_language_id", edit_language_id);
        model.addAttribute("language", language);

        return "editLanguage";

    }

    @PostMapping("/languages/edit/{id}")
    public String edit(@PathVariable("id") int edit_language_id, @Valid @ModelAttribute("language") Language language, BindingResult bindingResult, Model model) {
        //test the binding result against the model for errors
        System.out.println("received UPDATE info to the POST route...");
        model.addAttribute("edit_language_id", edit_language_id);

        if (bindingResult.hasErrors()) {
            System.out.println("Errors in data");
            return "editLanguage";
        } else {
            System.out.println("Data were valid, updating language");
            languageService.updateLanguage(edit_language_id, language);

            return "redirect:/languages";
        }



    }


    //todo: DELETION
    @RequestMapping("/languages/delete/{id}")
    public String destroy(@PathVariable("id") int selected_language_id) {
        System.out.println("trying to delete language with id: " + selected_language_id);

        //call the service's method to delete the language
        languageService.destroyLanguage(selected_language_id);

        return "redirect:/languages";
    }




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
