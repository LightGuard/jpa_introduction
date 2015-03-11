package edu.persistence.listener;

import javax.persistence.PostPersist;

import edu.persistence.model.Book;

public class BookListener {
    @PostPersist
    public void newBookAlert(Book b) {
        System.out.println("New book added! - " + b.toString());
    }
}
