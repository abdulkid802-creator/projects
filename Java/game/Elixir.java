public class Elixir extends Item{

    Elixir(){
        super("Elixir");
    }

    @Override
    void use(Player player){
        player.currentHP += 60;
        player.currentHP = Math.min(player.currentHP, player.maxHp);
        System.out.println("You gained 60 HP current HP is: " + player.currentHP);
    }
}
