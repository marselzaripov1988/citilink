package tech.itpark.citilink.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book extends Product {
    private String author;

    public Book(long id, String name, int price, String author, boolean removed) {
        super(id, name, price, removed);
        this.author = author;
    }
}
