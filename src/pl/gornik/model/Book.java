package pl.gornik.model;

import pl.gornik.Produkt;

public class Book extends Produkt {
    String author;
    public Book(String title, int numberOfProductsInStock, double price) {
        super(title, numberOfProductsInStock, price);
    }

    public Book(String title, int numberOfProductsInStock, double price, String author) {
        super(title, numberOfProductsInStock, price);
        this.author = author;
    }

    @Override
    public String displayProduct() {
        return super.displayProduct() +
                "author: " + author;
    }
}
