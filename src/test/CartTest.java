package src.test;

import org.junit.Before;
import org.junit.Test;

import src.cart.Cart;
import src.coupon.*;
import src.product.Product;
import src.sort.PriceNameReverse;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CartTest {
    private Cart cart;

    @Before
    public void setup() {cart = new Cart();}

    @Test
    public void get_products_test(){
        cart.addProduct(new Product("1", "bread", 33));
        List<Product> result = cart.getProducts();

        assertEquals("get products", result.size(), 1);
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

        assertEquals("get all products value",80, result , 1);
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

        assertEquals("Great test x_x", 6, cart.getProducts().size());

    }

    @Test
    public void sorting_test(){
        cart.addProduct(new Product("1", "a", 50));
        cart.addProduct(new Product("2", "b", 50));
        cart.addProduct(new Product("3", "c", 50));
        cart.addProduct(new Product("4", "a", 100));
        cart.addProduct(new Product("5", "b", 100));
        cart.addProduct(new Product("6", "c", 100));
        // a: 100, b: 100, c: 100, a: 50, b: 50, c: 50
        assertEquals("sorting test", "a: 100.0", cart.getProductsNames().get(0));
    }

    @Test
    public void change_sort_type_test(){
        cart.addProduct(new Product("1", "a", 50));
        cart.addProduct(new Product("2", "b", 50));
        cart.addProduct(new Product("3", "c", 50));
        cart.addProduct(new Product("4", "a", 100));
        cart.addProduct(new Product("5", "b", 100));
        cart.addProduct(new Product("6", "c", 100));
        cart.changeSortType(new PriceNameReverse());
        // c: 100, b: 100, a: 100, c: 50, b: 50, a: 50
        assertEquals("sorting test", "c: 100.0", cart.getProductsNames().get(0));
    }

    @Test
    public void find_cheapest_test(){
        cart.addProduct(new Product("1", "a", 50));
        cart.addProduct(new Product("2", "b", 100));
        cart.addProduct(new Product("3", "c", 25));
        Product result = cart.findCheapest();
        assertEquals("find cheapest","c", result.getName());
    }

    @Test
    public void find_expensive_test(){
        cart.addProduct(new Product("1", "a", 50));
        cart.addProduct(new Product("2", "b", 100));
        cart.addProduct(new Product("3", "c", 25));
        Product result = cart.findMostExpensive();
        assertEquals("find cheapest","b", result.getName());
    }

    @Test
    public void find_n_cheapest_test(){
        cart.addProduct(new Product("1", "a", 50));
        cart.addProduct(new Product("2", "b", 100));
        cart.addProduct(new Product("3", "c", 25));
        List<Product> result = cart.findNCheapest(2);
        assertEquals("find cheapest","a", result.get(1).getName());
    }

    @Test
    public void find__n_expensive_test(){
        cart.addProduct(new Product("1", "a", 50));
        cart.addProduct(new Product("2", "b", 100));
        cart.addProduct(new Product("3", "c", 25));
        List<Product> result = cart.findNMostExpensive(2);
        assertEquals("find cheapest","a", result.get(1).getName());
    }

    @Test
    public void check_all_products_value(){
        cart.addProduct(new Product("1", "a", 150));
        cart.addProduct(new Product("2", "b", 100));
        cart.addProduct(new Product("3", "c", 250));
        cart.addCoupon(new Discount_5());
        double result = cart.getCartValue();
        assertEquals("Check products value", result, 475.0, 1);
    }

}
