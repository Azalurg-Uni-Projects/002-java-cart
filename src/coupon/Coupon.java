package src.coupon;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coupon {
    private String code;

    public Coupon(){}
    public Coupon(String code){
        this.code = code;
    }
}
