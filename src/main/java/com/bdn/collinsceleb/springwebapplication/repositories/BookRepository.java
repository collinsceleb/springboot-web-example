package com.bdn.collinsceleb.springwebapplication.repositories;

import com.bdn.collinsceleb.springwebapplication.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
