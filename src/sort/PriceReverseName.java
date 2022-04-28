package src.sort;

import src.product.Product;

import java.util.Comparator;

public class PriceReverseName implements Comparator<Product> {
    @Override
    public int compare(Product a, Product b) {
        int price = a.getPrice().compareTo(b.getPrice());
        int name = a.getName().compareTo(b.getName());

        return ((price == 0) ? name : price);
    }
}
