package pl.gornik;

import pl.gornik.model.Book;
import pl.gornik.model.Disc;
import pl.gornik.model.Toy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Produkt> stanSklepu = new ArrayList<>();
        List<Produkt> koszyk = new ArrayList<>();
        stanSklepu.add(new Book("Opowieści z narni", 20, 49.99, "C.S. Lewis"));
        stanSklepu.add(new Book("Harry Potter", 50, 35.99, "J.K Rowling"));
        stanSklepu.add(new Book("Metro 2033", 10, 59.99, "Dmitrij Głuchowski"));
        stanSklepu.add(new Book("Wiedźmin", 60, 49.99, "Andrzej Sapkowski"));

        stanSklepu.add(new Disc("Hot Coffee", 250, 25.99, "Schafter"));
        stanSklepu.add(new Disc("Deszcz na betonie", 150, 19.99, "Taco Hemingway"));
        stanSklepu.add(new Disc("Everlasting Dance", 50, 45.99, "Llunr"));
        stanSklepu.add(new Disc("Van Gogh", 20, 23.99, "Alnev"));

        stanSklepu.add(new Toy("Nerf", 10, 49.99, 12));
        stanSklepu.add(new Toy("Hot Wheels", 60, 9.99, 6));
        stanSklepu.add(new Toy("Freezbie", 45, 20.99, 5));
        stanSklepu.add(new Toy("Barbie", 100, 39.99, 3));

        for(Produkt produkt: stanSklepu) {
            System.out.println(produkt.displayProduct());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Zrób zakupy! Wybierz produkty które chcesz kupić. Wypisz produktu którego chcesz zakupić.");
        System.out.println();

        boolean czyDalej = true;

        while(czyDalej) {
            System.out.println("Wybierz Produkt.");
            String wybor = scanner.next();

            for (Produkt produkt : stanSklepu) {
                if (wybor.equals(produkt.getTitle())) {
                    Produkt prod = new Produkt(produkt);
                    System.out.println("Ile chcesz kupić sztuk tego produktu.");
                    int ilosc = scanner.nextInt();
                    if(ilosc > produkt.getNumberOfProductsInStock()) {
                        System.out.println("Niestety nie mamy takiej ilosci produktu. Aktualny numer towaru to: " + produkt.getNumberOfProductsInStock());
                        break;
                    } else {
                        prod.setNumberOfProductsInStock(ilosc);
                        koszyk.add(prod);
                        System.out.println(koszyk.get(0).displayProduct());
                        produkt.setNumberOfProductsInStock(produkt.getNumberOfProductsInStock() - ilosc);
                        break;
                    }
                }
            }
            System.out.println("Czy chcesz dodać do koszyka coś jeszcze (wybierz 1) czy chcesz przejść do Koszyka (wybierz 2).");
            int wybor_end = scanner.nextInt();
            if(wybor_end == 1) {
                czyDalej = true;
            } else if(wybor_end == 2) {
                czyDalej = false;
                break;
            }
        }

        Map<Produkt, Integer> elementCounts = new HashMap<>();
        for (Produkt item : koszyk) {
            elementCounts.put(item, elementCounts.getOrDefault(item, 0) + 1);
        }

        // Clear the original list
        koszyk.clear();

        // Rebuild the list with merged elements
        // Rebuild the list with merged elements
        // Rebuild the list with merged elements
        for (Map.Entry<Produkt, Integer> entry : elementCounts.entrySet()) {
            Produkt item = entry.getKey();
            int count = entry.getValue();
            // Merge duplicates by appending count to the item name
            if (count > 1) {
                for (int i = 1; i <= count; i++) {
                    String mergedName = item.getTitle() + i; // Tworzymy nową nazwę produktu
                    Produkt mergedProdukt = new Produkt(mergedName); // Tworzymy nowy obiekt Produkt
                    koszyk.add(mergedProdukt); // Dodajemy nowy obiekt Produkt do listy
                }
            } else {
                koszyk.add(item);
            }
        }



    }
}