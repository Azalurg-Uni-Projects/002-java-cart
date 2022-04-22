package src.coupon;

import src.cart.Cart;
import src.product.Product;

public class Discount_5 implements Coupon{

    @Override
    public void apply(Cart cart) {
        Product[] products = cart.getProducts();
        if (cart.getProductsValue() > 300){
            for (Product product : products) {
                product.setDiscountPrice(product.getDiscountPrice() * 0.95);
            }
        }

    }
}