package src.sort;

import src.product.Product;

import java.util.Comparator;

public class PriceName implements Comparator<Product> {
    @Override
    public int compare(Product a, Product b) {
        int price = b.getPrice().compareTo(a.getPrice());
        int name = a.getName().compareTo(b.getName());

        if (price == 0){
            return name;
        }
        return price;
    }
}
