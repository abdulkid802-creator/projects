public class Product {

    String name;
    double price;
    String category;
    String barcode;

    Product(String name, double price, String category, String barcode){
        this.name = name;
        this.price = price;
        this.category = category;
        this.barcode = barcode;
    }

    void getDetails(){
        System.out.println("Name: " + name + " Price: " + price + " Category: " + category + " Barcode: " + barcode);
    }
}
