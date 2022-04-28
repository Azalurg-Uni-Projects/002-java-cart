package src.sort;

import src.product.Product;

import java.util.Comparator;

public class Name implements Comparator<Product> {
    @Override
    public int compare(Product a, Product b) {
        return a.getName().compareTo(b.getName());
    }
}
