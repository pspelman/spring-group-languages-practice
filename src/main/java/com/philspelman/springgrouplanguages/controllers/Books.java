package com.philspelman.springgrouplanguages.controllers;

import com.philspelman.springgrouplanguages.models.Book;
import com.philspelman.springgrouplanguages.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class Books {
    //need to bring in the connection to the data manager (the Service)
    private final BookService bookService;
    //Hook up the service
    public Books(BookService bookService) {
        this.bookService = bookService;
    }


    @RequestMapping("/books")
    public String books(Model model) {
        List<Book> books = bookService.allBooks();

        model.addAttribute("books", books);
        return "books";
    }

    @RequestMapping(value = "/books/id/getById/")
    public String findBookByIndex(@ModelAttribute("errors") String errors,
                                  @RequestParam("find_book_id") String findId,
                                  RedirectAttributes redirectAttributes) {

        System.out.println("got form post for book id: " + findId);
        String redirectRoute = String.format("/books/%s",findId);

        return "redirect:" + redirectRoute;

    }



    // FIND BOOK BY ID
    @RequestMapping("/books/{book_id}")
    public String findBookByIndex(Model model, @PathVariable("book_id") Long book_id) {
        System.out.println("Books Controller: reached /books/book_id route for book: " + book_id);

        model.addAttribute("book_id", book_id);
        model.addAttribute("selectedBook", bookService.findBookById(book_id));

        return "showBook";
    }
//    @RequestMapping("/books/{book_id}")
//    public String findBookByIndex(Model model, @PathVariable("book_id") String book_id) {
//
//        System.out.println("Books Controller: reached /books/book_id route for book: " + book_id);
//        model.addAttribute("book_id", book_id);
//
//
//        Integer book_index = Integer.parseInt(book_id);
//        System.out.println("book_index: " + book_index);
//
//        try {
//            System.out.println("entered try block....trying to get the book");
////            Book selectedBook = bookService.findBookByIndex(book_index);
//            Book selectedBook = bookService.findBookById(book_index);
//            System.out.println("book desc: " + selectedBook.getDescription());
//            model.addAttribute("selectedBook", selectedBook);
//
//        } catch (Exception err) {
//            System.out.println("Exception caught: " + err);
//
//        }
//        return "showBook";
//    }


    // CREATE NEW BOOKS
    @RequestMapping("/books/new")
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult) {
        System.out.println("BookForm stuff");
        if (bindingResult.hasErrors()) {
            System.out.println("there were errors");
            return "bookForm";
        } else {
            System.out.println("No errors....trying to add book");

            //NEED TO SAVE THE BOOK
            bookService.addBook(book);

            return "redirect:/";
        }
    }

    // EDIT/UPDATE BOOK (show the form)
    @RequestMapping("/books/edit/{id}")
    public String editBook(@PathVariable("id") Long edit_book_id, Model model) {
        System.out.println("reached EDIT id route with id: " + edit_book_id);

//        Book book = bookService.findBookByIndex(edit_book_id);
        Book book = bookService.findBookById(edit_book_id);

        model.addAttribute("edit_book_id", edit_book_id);

        if (book != null) {
            model.addAttribute("book", book);
            return "editBook";
        } else {
            return "redirect:/books";
        }
    }


    //HANDLE AN UPDATE
    @PostMapping("/books/edit/{id}")
    public String updateBook(@PathVariable("id") Long edit_book_id, @Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model) {
        System.out.println("Trying to update the book");
        model.addAttribute("edit_book_id", edit_book_id);

        if (bindingResult.hasErrors()) {
            System.out.println("Errors in update info");
            return "editBook";
        } else {
            System.out.println("data were valid...trying to update the book");

//            bookService.updateBook(edit_book_id, book);
            bookService.updateBook(book);
            return "redirect:/books";

        }
    }

    @RequestMapping("/books/delete/{id}")
    public String destroy(@PathVariable("id") Long selected_book_id) {
        System.out.println("Request to delete book: " + selected_book_id);

        bookService.destroyBook(selected_book_id);

        return "redirect:/books";
    }





//    //NOW MAKE THE ABILITY TO ADD NEW BOOKS!
//    @RequestMapping("/books/new")
//    public String newBook(@ModelAttribute("book") Book book) {
//        System.out.println("BookForm stuff");
//
//        return "bookForm";
//    }
//


}
