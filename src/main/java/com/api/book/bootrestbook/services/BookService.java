package com.api.book.bootrestbook.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    // private static List<Book> list = new ArrayList<Book>();

    // static {
    //     list.add(new Book(1, "Java Book", "Akshay"));
    //     list.add(new Book(2, "Python", "Sailesh"));
    //     list.add(new Book(3, "C", "Vikas"));

    // }

    // get all book
    public List<Book> getAllBooks() {
        List<Book> list=(List) bookRepository.findAll() ;
        return list;
    }

    // get single book by id
    public Book getBookById(int id) {
        Book book = null;
        try {
            // book = list.stream().filter(e -> e.getId() == id).findFirst().get();
             book =bookRepository.findById(id);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return book;
    }

    // adding the book
    public Book addBook(Book b) {
        Book result = bookRepository.save(b);
        return result;
    }

    // delete book
    public void deleteBook(int bid) {
         // list = list.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());
            bookRepository.deleteById(bid);    
    }

    // update the book
    public void updateBook(Book book, int bookId) {
        // Book b1 = null;
        // b1 = list.stream().filter(bo -> bo.getId() == bookId).findFirst().get();
        // System.out.println(b1);
        // if (b1 == null) {

        // } else {
        //     list = list.stream().map(b -> {
        //         if (b.getId() == bookId) {
        //             b.setTitle(book.getTitle());
        //             b.setAuthor(book.getAuthor());
        //         }
        //         return b;
        //     }).collect(Collectors.toList());
        // }

        
        book.setId(bookId);
        bookRepository.save(book);
    }

    // //update the book
    // public void updateBook(Book book,int bookId){
    // list = list.stream().map(b->{
    // if (b.getId()==bookId) {
    // b.setTitle(book.getTitle());
    // b.setAuthor(book.getAuthor());
    // }
    // return b;
    // }).collect(Collectors.toList());
    // }

}
