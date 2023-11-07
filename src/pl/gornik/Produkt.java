package pl.gornik;

import java.util.Objects;

public class Produkt {
    private String title;
    private int numberOfProductsInStock;
    private double price;

    public Produkt(String title, int numberOfProductsInStock, double price) {
        this.title = title;
        this.numberOfProductsInStock = numberOfProductsInStock;
        this.price = price;
    }

    public Produkt(Produkt product) {
        this(product.title, product.numberOfProductsInStock, product.price);
    }



    public String displayProduct() {
        return "title: '" + title + '\'' +
                ", numberOfProductsInStock: " + numberOfProductsInStock +
                ", price: " + price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfProductsInStock() {
        return numberOfProductsInStock;
    }

    public void setNumberOfProductsInStock(int numberOfProductsInStock) {
        this.numberOfProductsInStock = numberOfProductsInStock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    //public double countPrice() {
   //     return
    //}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Objects.hashCode(this.title); // użyj odpowiedniego pola jako klucz
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Produkt other = (Produkt) obj;
        return Objects.equals(this.title, other.title); // użyj odpowiedniego pola jako klucz
    }
}
