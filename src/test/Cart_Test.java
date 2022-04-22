package src.test;

import org.junit.Before;
import org.junit.Test;
import src.cart.Cart;
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
}
