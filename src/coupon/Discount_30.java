package src.coupon;

import src.cart.Cart;
import src.product.Product;

public class Discount_30 implements Coupon{

    @Override
    public void apply(Cart cart) {
        Product[] products = cart.getProducts();
        cart.setCartValue(0);
        for (Product product : products) {
            product.setDiscountPrice(product.getDiscountPrice() * 0.70);
        }
    }
}
