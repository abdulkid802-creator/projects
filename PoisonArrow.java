public class PoisonArrow extends Item{

    PoisonArrow(){
        super("Poison Arrow");
    }

    @Override
    void use(Player player){
        player.nextAttackPoisons = true;
        System.out.println("Next attack will poison the enemy!");
    }
}
