package pl.gornik.model;

import pl.gornik.Produkt;

public class Disc extends Produkt {
    String performer;
    public Disc(String title, int numberOfProductsInStock, double price) {
        super(title, numberOfProductsInStock, price);
    }

    public Disc(String title, int numberOfProductsInStock, double price, String performer) {
        super(title, numberOfProductsInStock, price);
        this.performer = performer;
    }

    @Override
    public String displayProduct() {
        return super.displayProduct() +
                "Musician: " + performer;

    }
}
