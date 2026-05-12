import java.util.Random;

public abstract class Player extends Character{

    Inventory inventory = new Inventory();

    Random rand = new Random();

    int coins = 0;
    int level = 1;
    int exp = 0;
    int cooldown = 0;
    boolean nextAttackPoisons = false;

    Player(String name ){
        super(name, 100, 100, 20,5);
    }

    @Override
    boolean attack(Character target){
        System.out.println(name + " is attacking " + target.name);
        int roll = rand.nextInt(10);


        if (roll == 0){
            System.out.println("Critical hit!");
            target.takeDamage(attackPower * 2);
            if (nextAttackPoisons) {
                target.poisonTurns = 3;
                System.out.println("Target is poisoned!");
                nextAttackPoisons = false;
            }
            return true;
        }
        else if (roll == 1){
            System.out.println("You missed your attack! ");
            return false;
        }
        else {

            if (nextAttackPoisons) {
                target.poisonTurns = 3;
                System.out.println("Target is poisoned!");
                nextAttackPoisons = false;
            }
            target.takeDamage(attackPower);
        }


        return true;





    }

    abstract boolean specialAbility(Character target);

    void gainExp(int amount){
        exp += amount;
        System.out.println("You gain " + amount + " of exp | Total exp is: " + exp);
        levelUp();
    }

    void gainCoin(int amount){
        coins += amount;
        System.out.println("You gain " + amount + " of coins | Total coin is: " + coins);
    }

    void levelUp(){
        if (exp >= level * 50){
            level += 1;
            attackPower += 20;
            defence += 6;
            maxHp += 35;
            currentHP = maxHp;
            System.out.println("⭐️ Level UP you are now lvl " + level);
            System.out.println();
        }

    }

    void addItem(Item item){
        inventory.addItem(item);
    }

    void useItem(Item item){
        item.use(this);
        inventory.removeItem(item);
    }

}
