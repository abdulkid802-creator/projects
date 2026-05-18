public class Discount {

    String  discountCode;
    double discountPercent;

    Discount(String discountCode, double discountPercent){
        this.discountCode = discountCode;
        this.discountPercent = discountPercent;
    }

    double applyDiscount(double total){
        total -= total * discountPercent;
        return total;
    }

    boolean inValid(String code){

        if (code.equals(discountCode)){
            return true;
        }
        return false;
    }
}
