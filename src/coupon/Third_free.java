package src.coupon;

import src.cart.Cart;
import src.product.Product;

import java.util.List;

public class Third_free implements Coupon{

    @Override
    public void apply(Cart cart) {
        List<Product> products = cart.getProducts();
        if(products.size() >= 3){
            double min_val = products.get(0).getPrice();
            int min_index = 0;

            for (int i = 0; i< products.size(); i++){
                if(products.get(i).getPrice() < min_val){
                    min_index = i;
                    min_val = products.get(min_index).getPrice();
                }
            }
            products.get(min_index).setDiscountPrice((double) 0);
        }
    }
}
