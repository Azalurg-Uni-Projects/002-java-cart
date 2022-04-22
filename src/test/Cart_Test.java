package src.test;

import org.junit.Before;
import org.junit.Test;

import src.cart.Cart;
import src.coupon.*;
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

    @Test
    public void great_cart_test(){
        cart.addProduct(new Product("1", "backpack", 100));
        cart.addProduct(new Product("2", "bag", 50));
        cart.addCoupon(new Discount_5());
        cart.addProduct(new Product("3", "pocket", 11));
        cart.addCoupon(new Third_free());
        if(cart.getCartValue() < 160){
            cart.addCoupon(new Amazon_30());
        }
        cart.addProduct(new Product("4", "Amazon", 500));
        if(cart.getCartValue() < 600){
            cart.addCoupon(new Free_cup_relative());
        }
        cart.addCoupon(new Free_cup_absolut());

        assertEquals("Great test x_x", 6, cart.getProducts().length);

    }
}
