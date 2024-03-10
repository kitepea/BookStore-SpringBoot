package com.springbootjpa.imaginaryengineering.controller;

import com.springbootjpa.imaginaryengineering.entity.Book;
import com.springbootjpa.imaginaryengineering.entity.MyBook;
import com.springbootjpa.imaginaryengineering.service.BookService;
import com.springbootjpa.imaginaryengineering.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService service;
    
    @Autowired
    private MyBookListService myBookService;
    
    @GetMapping("/")
    public String home() {
        return "home";
    }
    
    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }
    
    @GetMapping("/available_books")
    public ModelAndView getAllBooks() {
        List<Book> list = service.getAllBooks();
        return new ModelAndView("booklist", "book", list);
    }
    
    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b) {
        service.save(b);
        return "redirect:/available_books";
    }
    
    @GetMapping("/my_books")
    public String getMyBooks(Model model) {
        List<MyBook> myBookList = myBookService.getAllMyBooks();
        model.addAttribute("book", myBookList);
        return "myBooks";
    }
    
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Book b = service.getBookById(id);
        MyBook mb = new MyBook(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
        myBookService.saveMyBook(mb);
        return "redirect:/my_books";
    }
    
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        Book b = service.getBookById(id);
        model.addAttribute("book", b);
        return "bookEdit";
    }
    
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id, Model model) {
        service.deleteBookById(id);
        return "redirect:/available_books";
    }
}
