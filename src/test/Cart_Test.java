package src.test;

import org.junit.Before;
import org.junit.Test;
import src.cart.Cart;
import src.coupon.Coupon;
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
        int expected = 1;

        assertEquals("get products", result.length, expected);
    }

    @Test
    public void get_coupon_test(){
        String expected = "Promocja na masło";
        cart.addCoupon(new Coupon(expected));
        Coupon[] coupons = cart.getCoupons();
        String result = coupons[0].getCode();

        assertEquals("get coupon", result, expected);
    }
}
