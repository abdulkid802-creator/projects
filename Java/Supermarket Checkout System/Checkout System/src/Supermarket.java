import java.util.ArrayList;

public class Supermarket {

    ArrayList<Product> products = new ArrayList<>();

    void addProduct(Product product){
        products.add(product);
    }

    Product findProduct(String barcode){

        for (Product product : products){
            if (product.equals(barcode)){
                return product;
            }
        }
        return null;
    }

    void showAllProduct(){

        for (Product product : products){
            System.out.println(product);
        }
    }
}
