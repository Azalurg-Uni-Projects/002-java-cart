package src.cart;

import lombok.Getter;
import src.coupon.Coupon;
import src.product.Product;

@Getter
public class Cart {
    private Product[] products;
    private Coupon[] coupons;
    private double cartValue;
    private double productsValue;

    public Cart(){
        this.products = new Product[0];
        this.coupons = new Coupon[0];
    }

    private void calculate(){

    }

    public void addProduct(Product p){
        Product[] newList = new Product[products.length + 1];
        for(int i = 0; i < products.length; i++){
            newList[i] = products[i];
        }
        products = newList;
        products[products.length-1] = p;
        this.productsValue = this.productsValue + p.getPrice();
        calculate();
    }

    public void addCoupon(Coupon c){
        Coupon[] newList = new Coupon[coupons.length + 1];
        for(int i = 0; i < coupons.length; i++){
            newList[i] = coupons[i];
        }
        coupons = newList;
        coupons[coupons.length-1] = c;
        calculate();
    }

    public void resetCart(){
        this.products = new Product[0];
        this.coupons = new Coupon[0];
    }

    public void setCartValue(double cartValue){
        this.cartValue = cartValue;
    }

}
