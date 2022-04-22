package src.test;

import org.junit.Before;
import org.junit.Test;

import src.cart.Cart;
import src.coupon.Coupon;
import src.coupon.Discount_5;
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
        cart.addCoupon(new Discount_5());
        Coupon[] result =  cart.getCoupons();

        assertEquals("get coupon", result.length, 1);
    }

    @Test
    public void get_all_products_value(){
        cart.addProduct(new Product("101", "mleko", 10));
        cart.addProduct(new Product("102", "kawa", 70));
        double result = cart.getProductsValue();

        assertEquals("get all products value", result, 80, 1);
    }
}
