package com.bdn.collinsceleb.springwebapplication.repositories;

import com.bdn.collinsceleb.springwebapplication.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
