package com.philspelman.springgrouplanguages.controllers;

import com.philspelman.springgrouplanguages.models.Book;
import com.philspelman.springgrouplanguages.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class Books {

    private final BookService bookService;

    public Books(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String books(Model model) {
        List<Book> books = bookService.allBooks();

        model.addAttribute("books", books);
        return "books";
    }

    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "bookForm";
    }


}
