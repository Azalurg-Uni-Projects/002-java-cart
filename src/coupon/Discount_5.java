package src.coupon;

import src.cart.Cart;
import src.product.Product;

import java.util.List;

public class Discount_5 implements Coupon{

    @Override
    public void apply(Cart cart) {
        List<Product> products = cart.getProducts();
        for (Product product : products) {
            product.setDiscountPrice(product.getDiscountPrice() * 0.95);
        }
    }

    @Override
    public boolean canApply(Cart cart) {
        return cart.getProductsValue() > 300;
    }
}
