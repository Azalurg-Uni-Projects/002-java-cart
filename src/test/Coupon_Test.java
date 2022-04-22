package src.test;


import src.cart.Cart;
import src.coupon.Discount_5;
import src.coupon.Free_cup_absolut;
import src.coupon.Free_cup_relative;
import src.coupon.Third_free;
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
    public void discount_5_test(){
        cart.addCoupon(new Discount_5());
        double expected = cart.getProductsValue() * 0.95;

        assertEquals("Discount 30%", cart.getCartValue(), expected, 2);
    }

    @Test
    public void free_cup_absolut_test(){
        cart.addCoupon(new Free_cup_absolut());
        int expected = 6;

        assertEquals("Free cup absolut", cart.getProducts().length, expected);
    }

    @Test
    public void free_cup_relative_test(){
        cart.addCoupon(new Free_cup_relative());
        int expected = 6;

        assertEquals("Free cup relative", cart.getProducts().length, expected);
    }

    @Test
    public void third_free_test(){
        cart.addCoupon(new Third_free());
        double expected = 9154;

        assertEquals("Third free", cart.getCartValue(), expected, 1);
    }
}
