package src.coupon;

import src.cart.Cart;
import src.product.Product;

public class Free_cup_absolut implements Coupon {
    @Override
    public void apply(Cart cart) {
        if (cart.getProductsValue() > 200){
            cart.addProduct(new Product("666", "Red cup", 0));
        }
    }
}
