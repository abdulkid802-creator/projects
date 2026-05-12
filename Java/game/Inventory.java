import java.util.ArrayList;

public class Inventory {

    ArrayList<Item> items = new ArrayList<>();

    void addItem(Item item){
        items.add(item);
    }

    void removeItem(Item item){
        items.remove(item);
    }

    void showInventory(){
         for (int i = 0; i < items.size(); i++){
                System.out.println(i + 1 + ". " + items.get(i).getName());
            }
        }
    }

