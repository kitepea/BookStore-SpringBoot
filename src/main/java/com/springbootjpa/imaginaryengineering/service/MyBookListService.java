package com.springbootjpa.imaginaryengineering.service;

import com.springbootjpa.imaginaryengineering.entity.MyBook;
import com.springbootjpa.imaginaryengineering.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService {
    @Autowired
    private MyBookRepository mybook;
    
    public void saveMyBook(MyBook book) {
        mybook.save(book);
    }
    
    public List<MyBook> getAllMyBooks() {
        return mybook.findAll();
    }
    
    public void deleteById(int id) {
        mybook.deleteById(id);
    }
}
