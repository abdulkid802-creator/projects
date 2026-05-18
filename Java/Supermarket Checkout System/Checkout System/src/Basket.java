import java.util.ArrayList;

public class Basket {

    ArrayList<Product> products = new ArrayList<>();

    void addProduct(Product product){
        products.add(product);
    }

    boolean removeProduct(String barcode){

        products.removeIf(product -> product.barcode.equals(barcode));
        return false;
    }

    double getTotal(){

        double total = 0;

        for (Product product : products){
            total += product.price;
        }

        return total;
    }

    void showBasket(){

        for (Product product : products){
             product.getDetails();
        }
    }
}
