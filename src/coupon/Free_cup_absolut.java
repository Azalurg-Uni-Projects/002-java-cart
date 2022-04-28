package src.coupon;

import src.cart.Cart;
import src.product.Product;

import java.util.List;
import java.util.Objects;

public class Free_cup_absolut implements Coupon {
    @Override
    public void apply(Cart cart) {
        List<Product> products = cart.getProducts();
        boolean should_add = true;

        if (cart.getProductsValue() > 200){
            for (Product product : products){
                if (Objects.equals(product.getName(), "Red cup")) {
                    should_add = false;
                    break;
                }
            }
        }else{
            should_add = false;
        }

        if(should_add){
            cart.addProduct(new Product("666", "Red cup", 0));
        }
    }
}
