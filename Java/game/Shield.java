public class Shield extends Item{

    Shield(){
        super("Shield");
    }

    @Override
    void use(Player player){
        player.defence += 3;
        System.out.println("You gained 3 defence current defence is: " + player.defence);
    }
}
