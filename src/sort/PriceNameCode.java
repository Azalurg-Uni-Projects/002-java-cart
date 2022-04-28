package src.sort;

import src.product.Product;

import java.util.Comparator;

public class PriceNameCode implements Comparator<Product> {

    @Override
    public int compare(Product a, Product b){
        int price = b.getPrice().compareTo(a.getPrice());
        int name = a.getName().compareTo(b.getName());
        int code = a.getCode().compareTo(b.getCode());
        if (price == 0){
            return ((name == 0) ? code : name);
        }
        return price;
    }
}
