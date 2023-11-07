package pl.gornik.model;

import pl.gornik.Produkt;

public class Toy extends Produkt {
    int minimal_age;
    public Toy(String title, int numberOfProductsInStock, double price) {
        super(title, numberOfProductsInStock, price);
    }

    public Toy(String title, int numberOfProductsInStock, double price, int minimal_age) {
        super(title, numberOfProductsInStock, price);
        this.minimal_age = minimal_age;
    }

    @Override
    public String displayProduct() {
        return super.displayProduct() +
        "minimum_age: " + minimal_age;
    }
}
