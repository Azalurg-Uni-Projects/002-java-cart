package src.test;

import org.junit.Before;
import org.junit.Test;
import src.cart.Cart;
import src.coupon.Coupon;
import src.coupon.Discount_30;
import src.product.Product;

import static org.junit.Assert.*;

public class Cart_Test {
    private Cart cart;

    @Before
    public void setup() {cart = new Cart();}

    @Test
    public void get_products_test(){
        cart.addProduct(new Product());
        Product[] result = cart.getProducts();

        assertEquals("get products", result.length, 1);
    }

    @Test
    public void get_coupon_test(){
        cart.addCoupon(new Discount_30());
        Coupon[] result =  cart.getCoupons();

        assertEquals("get coupon", result.length, 1);
    }
}
