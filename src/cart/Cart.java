package src.cart;

import lombok.Getter;
import src.coupon.Coupon;
import src.product.Product;
import src.sort.PriceName;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
public class Cart {
    private List<Product> products;
    private Coupon[] coupons;
    private double cartValue;
    private double productsValue;
    private Comparator sortType;

    public Cart(){
        this.products = new ArrayList<Product>();
        this.coupons = new Coupon[0];
        this.sortType = new PriceName();
    }

    private void calculate(){
        this.cartValue = 0;
        for(Coupon coupon : coupons) {
            coupon.apply(this);
        }
        for (Product product : products) {
            setCartValue(getCartValue() + product.getDiscountPrice());
        }
        this.products.sort(sortType);
    }

    public void addProduct(Product p){
        products.add(p);
        productsValue = productsValue + p.getPrice();
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
        this.products = new ArrayList<Product>();
        this.coupons = new Coupon[0];
    }

    public void setCartValue(double cartValue){
        this.cartValue = cartValue;
    }

    public void changeSortType(Comparator c){
        sortType = c;
        calculate();
    }

    public ArrayList<String> getProductsNames(){
        ArrayList<String> result = new ArrayList<String>();
        for (Product product : products){
            result.add(product.getName() + ": " + product.getPrice());
        }
        return result;
    }
    
    public Product findCheapest(){
        List<Product> list = products
                .stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .toList();
        return list.get(0);
    }
}

    public Product findMostExpensive(){
        List<Product> list = products
                .stream()
                .sorted(Comparator
                        .comparing(Product::getPrice)
                        .reversed())
                .toList();
        return list.get(0);
    }
}

