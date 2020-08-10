package com.bdn.collinsceleb.springwebapplication.bootstrap;

import com.bdn.collinsceleb.springwebapplication.models.Author;
import com.bdn.collinsceleb.springwebapplication.models.Book;
import com.bdn.collinsceleb.springwebapplication.models.Publisher;
import com.bdn.collinsceleb.springwebapplication.repositories.AuthorRepository;
import com.bdn.collinsceleb.springwebapplication.repositories.BookRepository;
import com.bdn.collinsceleb.springwebapplication.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData() {

        // Eric
        Publisher ericPublisher = new Publisher();
        ericPublisher.setName("Harper Collins");
        ericPublisher.setAddress("12345678");
        publisherRepository.save(ericPublisher);
        Author eric = new Author("Eric", "Evans");
        Book ericBook = new Book("Domain Driven Design", "1234", ericPublisher);
        eric.getBooks().add(ericBook);
        ericBook.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ericBook);


        // Rod
        Publisher rodPublisher = new Publisher();
        rodPublisher.setName("Worx");
        rodPublisher.setAddress("2345678");
        publisherRepository.save(rodPublisher);
        Author rod = new Author("Rod", "Johnson");
        Book rodBook = new Book("J2EE Development without EJB", "12345", rodPublisher);
        rod.getBooks().add(rodBook);
        rodBook.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(rodBook);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
