package src.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String code;
    private String name;
    private Double price;
    private Double discountPrice;

    public Product(String code, String name, Double price){
        this.code = code;
        this.name = name;
        this.price = price;
        this.discountPrice = price;
    }

    public Product(String code, String name, int price){
        this.code = code;
        this.name = name;
        this.price = (double) price;
        this.discountPrice = (double) price;
    }


}
