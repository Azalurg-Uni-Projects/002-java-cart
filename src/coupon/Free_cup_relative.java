package src.coupon;

import src.cart.Cart;
import src.product.Product;

import java.util.List;
import java.util.Objects;

public class Free_cup_relative implements Coupon {
    @Override
    public void apply(Cart cart) {
        List<Product> products = cart.getProducts();
        boolean should_add = true;

        double quick_count = 0;

        for (Product product : products) {
            quick_count = quick_count+ product.getDiscountPrice();
        }

        if (quick_count > 200){
            for (Product product : products){
                if (Objects.equals(product.getName(), "Green cup")) {
                    should_add = false;
                    break;
                }
            }
        }else{
            should_add = false;
        }

        if(should_add){
            cart.addProduct(new Product("420", "Green cup", (double) 0));
        }
    }

    @Override
    public boolean canApply(Cart cart) {
        return false;
    }
}
