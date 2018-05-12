package com.philspelman.springgrouplanguages.services;

import com.philspelman.springgrouplanguages.models.Book;
import com.philspelman.springgrouplanguages.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    //add a repository so that it can be injected and used for DB stuff
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;

    }

    //initialize the books variable with values
    private List<Book> books = new ArrayList<Book>(Arrays.asList(
            new Book("Harry Potter and the Sorcerer's Stone", "A boy wizard saving the world", "english", 309),
            new Book("The Great Gatsby", "The story primarily concerns the young and mysterious millionaire Jay Gatsby", "english", 180),
            new Book("Moby Dick", "The saga of Captain Ahab", "english", 544),
            new Book("Don Quixote", "Life of a retired country gentleman", "english", 150),
            new Book("The Odyssey", "Ancient Greek epic poem", "english", 475)
    ));


    //return all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();

//        return this.books;
    }

    public void addBook(Book newBook) {
        System.out.println("BookService: Trying to add the new book");
        bookRepository.save(newBook);

//        this.books.add(newBook);
    }

    public Book findBookById(Long id) {
        System.out.println("BookService says: FINDING BOOK BY INDEX");
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            //if the book is present, return it
            return optionalBook.get();
        } else {
            return null;
        }
    }

//    public Book findBookByIndex(int index) {
//        System.out.println("BookService says: FINDING BOOK BY INDEX");
//
//        if (index < books.size()) {
//            return books.get(index);
//        } else {
//            return null;
//        }
//    }
//




    public void updateBook(Book book) {
        //don't need the ID anymore because each book from the DB now has an ID built in
        bookRepository.save(book);
    }

//    public void updateBook(Long id, Book book) {
//        if (id < books.size()) { //book is found
//            System.out.println("updating book!");
//            books.set(id, book);
//        } else {
//            System.out.println("book not here");
//
//        }
//    }
//
    public void destroyBook(Long id) {
        System.out.println("trying to delete the book with id: " + id);
        bookRepository.deleteById(id);

    }
//    public void destroyBook(Long id) {
//        if (id < books.size()) {
//            books.remove(id);
//        }
//    }
}
