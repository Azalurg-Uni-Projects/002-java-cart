package src.test;


import src.cart.Cart;
import src.coupon.Discount_30;
import src.product.Product;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Coupon_Test {
    private Cart cart;

    @Before
    public void setup(){
        this.cart = new Cart();
        cart.addProduct(new Product("AAPL", "Apple", 2986));
        cart.addProduct(new Product("MSFT", "Microsoft", 2513));
        cart.addProduct(new Product("GOOG", "Google", 1927));
        cart.addProduct(new Product("AMZN", "Amazon", 1728));
        cart.addProduct(new Product("TSLA", "Tesla", 1204));
    }

    @Test
    public void discount_30_test(){
        cart.addCoupon(new Discount_30());
        double expected = cart.getProductsValue() * 0.7;

        assertEquals("Discount 30%", cart.getCartValue(), expected, 2);
    }
}
