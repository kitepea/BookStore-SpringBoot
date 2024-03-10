package com.springbootjpa.imaginaryengineering.repository;

import com.springbootjpa.imaginaryengineering.entity.MyBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookRepository extends JpaRepository<MyBook, Integer> {
}
