package src.coupon;

import src.cart.Cart;

public interface Coupon {
    public boolean apply(Cart cart);
}
