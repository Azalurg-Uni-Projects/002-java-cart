package src.coupon;

import src.cart.Cart;

public interface Coupon {
    public void apply(Cart cart);
    public boolean canApply(Cart cart);
}
