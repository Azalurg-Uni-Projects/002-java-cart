package src.coupon;

import src.cart.Cart;
import src.product.Product;

import java.util.List;
import java.util.Objects;

public class Free_cup_absolut implements Coupon {
    @Override
    public void apply(Cart cart) {
        cart.addProduct(new Product("666", "Red cup", 0));

    }

    @Override
    public boolean canApply(Cart cart) {
        List<Product> products = cart.getProducts();

        if (cart.getProductsValue() > 200){
            for (Product product : products){
                if (Objects.equals(product.getName(), "Red cup")) {
                    return false;
                }
            }
        }else{
            return false;
        }
        return true;
    }
}
