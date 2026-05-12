import java.util.Random;
import java.util.Scanner;

public class BattleEngine {

    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();


    Player player;
    Enemy enemy;
    public boolean playerRun = false;


    BattleEngine(Player player, Enemy enemy){
        this.player = player;
        this.enemy = enemy;

    }


    void start(){
        while (player.isAlive() && enemy.isAlive() && !playerRun) {

            playerTurn();

            if (player.cooldown > 0){
                player.cooldown -= 1;
            }

            enemyTurn();

            enemy.applyStatusEffects();
            player.applyStatusEffects();
        }

        if (playerRun){

        }

        else if (player.isAlive() && !enemy.isAlive()){
            player.gainExp(enemy.xpReward);
            player.gainCoin(enemy.coinReward);
            System.out.println("The player " + player.name + " won against " + enemy.name + " you gain " + enemy.xpReward + " exp & " + enemy.coinReward + " coins");
            System.out.println();
            int drop = rand.nextInt(8);

            if (drop == 0){
                System.out.println(enemy.name + " dropped a Health Potion");
                player.addItem(new HealthPotion());
            }
            else if (drop == 1){
                System.out.println(enemy.name + " dropped an Elixir");
                player.addItem(new Elixir());
            }
            else if (drop == 2){
                if (player instanceof Warrior){
                    System.out.println(enemy.name + " dropped a War Axe");
                    player.addItem(new WarAxe());
                } else if (player instanceof Mage){
                    System.out.println(enemy.name + " dropped a Spell Tome");
                    player.addItem(new SpellTome());
                } else if (player instanceof Archer){
                    System.out.println(enemy.name + " dropped a Poison Arrow");
                    player.addItem(new PoisonArrow());
                }
            }
            else if (drop == 3){
                if (player instanceof Warrior){
                    System.out.println(enemy.name + " dropped Heavy Armour");
                    player.addItem(new HeavyArmour());
                }
                else if (player instanceof Mage){
                    System.out.println(enemy.name + " dropped a Mana Crystal");
                    player.addItem(new ManaCrystal());
                }
                else if (player instanceof Archer){
                    System.out.println(enemy.name + " dropped Speed Boots");
                    player.addItem(new SpeedBoots());
                }
            }
            else if (drop == 4){
                System.out.println(enemy.name + " dropped a Shield");
                player.addItem(new Shield());
            }
            else {
                System.out.println("No item dropped");
            }
        }

        else if (enemy.isAlive() && !player.isAlive()){
            System.out.println("You lost to: " + enemy.name);
            player.currentHP = 0;
        }

        else {
            System.out.println("It's a draw");
            player.currentHP = 0;
        }

    }

    void playerTurn(){

        int choice;

        System.out.println(player.name + ": " + player.currentHP + "/" +player.maxHp + " Level " + player.level + " | " + enemy.name + ": " + enemy.currentHP + "/" +enemy.maxHp);

        System.out.println("1. Attack");
        System.out.println("2. Use Items");
        System.out.println("3. Special Ability");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        System.out.println();
        switch (choice){
            case 1 -> {
                boolean hit = player.attack(enemy);
                if (!hit){
                    System.out.println("Counter-attack!");
                    enemy.attack(player);
                }
            }
            case 2 -> {
                if (player.inventory.items.isEmpty()){
                    System.out.println("You have no items right now!");
                }
                else {
                    player.inventory.showInventory();
                    System.out.println("0. Use All Stat Items");
                    System.out.print("Choose an item: ");
                    int itemChoice = scanner.nextInt();
                    itemChoice -= 1;


                    if (itemChoice >= 0 && itemChoice < player.inventory.items.size()){
                        Item item = player.inventory.items.get(itemChoice);
                        player.useItem(item);
                        playerTurn();
                    }
                    else if (itemChoice == -1){
                        for (Item item : player.inventory.items) {
                            if (!(item instanceof HealthPotion) && !(item instanceof Elixir)) {
                                item.use(player);
                            }
                        }
                        player.inventory.items.removeIf(item -> !(item instanceof HealthPotion) && !(item instanceof Elixir));
                        playerTurn();
                    }
                    else {
                        System.out.println("Invalid choice");
                        playerTurn();
                    }
                }
            }
            case 3 -> {
               boolean used = player.specialAbility(enemy);
               if (!used){
                   playerTurn();
               }
            }
            case 4 -> {
                playerRun = true;
                System.out.println("You ran away");
            }
            default -> System.out.println("Invalid choice!");

        }
    }

    void enemyTurn(){
        if (!playerRun && enemy.isAlive()){
            if (enemy.isStunned){
                System.out.println("Enemy is stunned and can't attack!");
                enemy.isStunned = false;
            }
            else {
                enemy.attack(player);
            }
        }
    }


}
