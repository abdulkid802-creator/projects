import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Supermarket supermarket = new Supermarket();
        Product product = null;
        Discount discount1;
        Discount discount2;
        Discount discount3;
        Basket basket = new Basket();

        supermarket.addProduct(new Product("eggs", 5.99, "eggs", "e11229"));
        supermarket.addProduct(new Product("fish", 4.99, "fish", "f12229"));
        supermarket.addProduct(new Product("bread", 2.99, "Bread", "b11329"));
        supermarket.addProduct(new Product("Ice Cream", 6.99, "Ice Cream", "ic81229"));
        supermarket.addProduct(new Product("Cream", 10.99, "Cream", "c11889"));

        discount1 = new Discount("e11229", 0.4);
        discount2 = new Discount("b11329", 0.2);
        discount3 = new Discount("ic81229", 0.5);

        Scanner scanner = new Scanner(System.in);

        while (true){

            System.out.println("1. Scan product (add to basket by barcode)");
            System.out.println("2. Remove product from basket");
            System.out.println("3. View basket");
            System.out.println("4. Apply discount code");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");

            int choice;
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice){
                case 1 -> {
                    String name;
                    System.out.print("Enter product name: ");
                    name = scanner.nextLine();

                    double price;
                    System.out.print("Enter product price: ");
                    price = scanner.nextDouble();

                    scanner.nextLine();

                    String category;
                    System.out.print("Enter product category: ");
                    category = scanner.nextLine();

                    String barcode;
                    System.out.print("Enter product barcode: ");
                    barcode = scanner.nextLine();

                    product = new Product(name, price, category, barcode);
                    basket.addProduct(product);
                }
                case 2 -> {
                    String barcode;
                    System.out.print("Enter product barcode: ");
                    barcode = scanner.nextLine();

                    boolean removed = basket.removeProduct(barcode);

                    if (removed){
                        System.out.println("Product not found");
                    }
                    else {
                        System.out.println("The product " + product.name + " as been removed!");
                    }

                }
                case 3 -> basket.showBasket();
                case 4 -> {
                    String barcode;
                    System.out.print("Enter product barcode: ");
                    barcode = scanner.nextLine();

                    if (discount1.inValid(barcode)){
                        double discountedTotal = discount1.applyDiscount(basket.getTotal());
                        System.out.println("Discount as been added " + discountedTotal);
                    }
                    else if (discount2.inValid(barcode)){
                        double discountedTotal = discount2.applyDiscount(basket.getTotal());
                        System.out.println("Discount as been added " + discountedTotal);
                    }
                    else if (discount3.inValid(barcode)){
                        double discountedTotal = discount3.applyDiscount(basket.getTotal());
                        System.out.println("Discount as been added total discount " + discountedTotal);
                    }
                    else {
                        System.out.println("No discount as been applied!");
                    }
                }
                case 5 -> System.out.println("Your total items is: " + basket.getTotal());
                case 6 -> {
                    System.out.println("Thank your for shopping here come again soon!");
                    return;
                }
            }
        }

    }
}
