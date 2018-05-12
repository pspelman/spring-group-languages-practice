package com.philspelman.springgrouplanguages.controllers;

import com.philspelman.springgrouplanguages.models.Language;
import com.philspelman.springgrouplanguages.services.LanguageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class Languages {
    //need to bring in the connection to the data manager (the Service)
    private final LanguageService languageService;
    //Hook up the service
    public Languages(LanguageService languageService) {
        this.languageService = languageService;
    }


    @RequestMapping("/languages")
    public String languages(Model model) {
        List<Language> languages = languageService.allLanguages();

        model.addAttribute("languages", languages);
        return "languages";
    }

    @GetMapping("/languages/new")
    public String createLanguage(@ModelAttribute("language") Language language) {
        System.out.println("LanguageForm stuff");
            return "languageForm";
    }


    // CREATE NEW LANGUAGE
    @PostMapping("/languages/new")
    public String createLanguage(@Valid @ModelAttribute("language") Language language, BindingResult bindingResult) {
        System.out.println("LanguageForm stuff");
        if (bindingResult.hasErrors()) {
            System.out.println("there were errors");
            printBindingResultErrors(bindingResult);
            return "languageForm";
        } else {
            System.out.println("No errors....trying to add language");

            //NEED TO SAVE THE LANGUAGE
            languageService.addLanguage(language);

            return "redirect:/";
        }
    }

    public static void printBindingResultErrors(BindingResult bindingResult) {
        for (Object object : bindingResult.getAllErrors()) {
            if(object instanceof FieldError) {
                FieldError fieldError = (FieldError) object;

                System.out.println(fieldError.getCode());
            }

            if(object instanceof ObjectError) {
                ObjectError objectError = (ObjectError) object;

                System.out.println(objectError.getCode());
            }
        }
    }


    @RequestMapping(value = "/languages/id/getById/")
    public String findLanguageByIndex(@ModelAttribute("errors") String errors,
                                  @RequestParam("find_language_id") String findId,
                                  RedirectAttributes redirectAttributes) {

        System.out.println("got form post for language id: " + findId);
        String redirectRoute = String.format("/languages/%s",findId);

        return "redirect:" + redirectRoute;

    }



    // FIND BOOK BY ID
    @RequestMapping("/languages/{language_id}")
    public String findLanguageByIndex(Model model, @PathVariable("language_id") Long language_id) {
        System.out.println("Languages Controller: reached /languages/language_id route for language: " + language_id);

        model.addAttribute("language_id", language_id);
        model.addAttribute("selectedLanguage", languageService.findLanguageById(language_id));

        return "showLanguage";
    }

    // EDIT/UPDATE LANGUAGE (show the form)
    @RequestMapping("/languages/edit/{id}")
    public String editLanguage(@PathVariable("id") Long edit_language_id, Model model) {
        System.out.println("reached EDIT id route with id: " + edit_language_id);

//        Language language = languageService.findLanguageByIndex(edit_language_id);
        Language language = languageService.findLanguageById(edit_language_id);

        model.addAttribute("edit_language_id", edit_language_id);

        if (language != null) {
            model.addAttribute("language", language);
            return "editLanguage";
        } else {
            return "redirect:/languages";
        }
    }


    //HANDLE AN UPDATE
    @PostMapping("/languages/edit/{id}")
    public String updateLanguage(@PathVariable("id") Long edit_language_id, @Valid @ModelAttribute("language") Language language, BindingResult bindingResult, Model model) {
        System.out.println("Trying to update the language");
        model.addAttribute("edit_language_id", edit_language_id);

        if (bindingResult.hasErrors()) {
            System.out.println("Errors in update info");
            return "editLanguage";
        } else {
            System.out.println("data were valid...trying to update the language");

//            languageService.updateLanguage(edit_language_id, language);
            languageService.updateLanguage(language);
            return "redirect:/languages";

        }
    }

    @RequestMapping("/languages/delete/{id}")
    public String destroy(@PathVariable("id") Long selected_language_id) {
        System.out.println("Request to delete language: " + selected_language_id);


        languageService.destroyLanguage(selected_language_id);

        return "redirect:/";
    }



//    @RequestMapping("/languages/delete/{id}")
//    public String destroy(@PathVariable("id") Long selected_language_id) {
//        System.out.println("Request to delete language: " + selected_language_id);
//
//        languageService.destroyLanguage(selected_language_id);
//
//        return "redirect:/languages";
//    }
//




//    //NOW MAKE THE ABILITY TO ADD NEW BOOKS!
//    @RequestMapping("/languages/new")
//    public String newLanguage(@ModelAttribute("language") Language language) {
//        System.out.println("LanguageForm stuff");
//
//        return "languageForm";
//    }
//


}
