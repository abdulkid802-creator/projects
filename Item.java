public abstract class Item {

    private String name;

    Item(String name){
        this.name = name;

    }

    String getName(){
        return this.name;
    }

    abstract void use(Player player);
}
