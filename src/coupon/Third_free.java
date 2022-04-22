package src.coupon;

import src.cart.Cart;
import src.product.Product;

public class Third_free implements Coupon{

    @Override
    public void apply(Cart cart) {
        Product[] products = cart.getProducts();
        if(products.length >= 3){
            double min_val = products[0].getPrice();
            int min_index = 0;

            for (int i = 0; i< products.length; i++){
                if(products[i].getPrice() < min_val){
                    min_index = i;
                    min_val = products[min_index].getPrice();
                }
            }
            products[min_index].setDiscountPrice(0);
        }
    }
}
