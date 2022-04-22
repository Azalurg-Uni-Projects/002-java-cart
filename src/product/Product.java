package src.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String code;
    private String name;
    private double price;
    private double discountPrice;

    public Product(){};
    public Product(String code, String name, double price){
        this.code = code;
        this.name = name;
        this.price = price;
        this.discountPrice = price;
    }

}
