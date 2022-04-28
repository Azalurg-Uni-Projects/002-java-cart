package src.sort;

import src.product.Product;

import java.util.Comparator;

public class PriceNameReverse implements Comparator<Product> {
    @Override
    public int compare(Product a, Product b) {
        int price = b.getPrice().compareTo(a.getPrice());
        int name = b.getName().compareTo(a.getName());

        return ((price == 0) ? name : price);
    }
}
