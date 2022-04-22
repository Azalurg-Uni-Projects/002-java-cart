package src.coupon;

import src.cart.Cart;
import src.product.Product;

import java.util.Objects;

public class Amazon_30 implements Coupon{
    @Override
    public void apply(Cart cart) {
        Product[] products = cart.getProducts();
        for (Product product : products){
            if (Objects.equals(product.getName(), "Amazon")) {
                product.setDiscountPrice(product.getPrice() * 0.70);
            }
        }
    }
}
