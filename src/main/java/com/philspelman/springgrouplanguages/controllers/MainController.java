package com.philspelman.springgrouplanguages.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping
    public String index() {

        System.out.println("got to index");


        return "index";
    }


}
