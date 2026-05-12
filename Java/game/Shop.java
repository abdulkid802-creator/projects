import java.util.Scanner;

public class Shop {

    Scanner scanner = new Scanner(System.in);

    Shop(){
    }

    void open(Player player){
        while (true){
            System.out.println("🛒 Welcome to the Shop! | Coins: " + player.coins);
            System.out.println("1. Health Potion — 20 coins");
            System.out.println("2. Elixir — 80 coins");

            if (player instanceof Warrior){
                System.out.println("3. War Axe — 60 coins");
                System.out.println("4. Heavy Armour — 50 coins");
            } else if (player instanceof Mage){
                System.out.println("3. Spell Tome — 70 coins");
                System.out.println("4. Mana Crystal — 55 coins");
            } else if (player instanceof Archer){
                System.out.println("3. Poison Arrow — 40 coins");
                System.out.println("4. Speed Boots — 45 coins");
            }

            System.out.println("5. Leave shop");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    if (player.coins >= 20) {
                        player.coins -= 20;
                        player.addItem(new HealthPotion());
                        System.out.println("Bought a Health Potion!");
                    } else System.out.println("Not enough coins!");
                }
                case 2 -> {
                    if (player.coins >= 80) {
                        player.coins -= 80;
                        player.addItem(new Elixir());
                        System.out.println("Bought an Elixir!");
                    } else System.out.println("Not enough coins!");
                }
                case 3 -> {
                    if (player instanceof Warrior){
                        if (player.coins >= 60) {
                            player.coins -= 60;
                            player.addItem(new WarAxe());
                            System.out.println("Bought a War Axe!");
                        } else System.out.println("Not enough coins!");
                    } else if (player instanceof Mage){
                        if (player.coins >= 70) {
                            player.coins -= 70;
                            player.addItem(new SpellTome());
                            System.out.println("Bought a Spell Tome!");
                        } else System.out.println("Not enough coins!");
                    } else if (player instanceof Archer){
                        if (player.coins >= 40) {
                            player.coins -= 40;
                            player.addItem(new PoisonArrow());
                            System.out.println("Bought a Poison Arrow!");
                        } else System.out.println("Not enough coins!");
                    }
                }
                case 4 -> {
                    if (player instanceof Warrior){
                        if (player.coins >= 50) {
                            player.coins -= 50;
                            player.addItem(new HeavyArmour());
                            System.out.println("Bought Heavy Armour!");
                        } else System.out.println("Not enough coins!");
                    } else if (player instanceof Mage){
                        if (player.coins >= 55) {
                            player.coins -= 55;
                            player.addItem(new ManaCrystal());
                            System.out.println("Bought a Mana Crystal!");
                        } else System.out.println("Not enough coins!");
                    } else if (player instanceof Archer){
                        if (player.coins >= 45) {
                            player.coins -= 45;
                            player.addItem(new SpeedBoots());
                            System.out.println("Bought Speed Boots!");
                        } else System.out.println("Not enough coins!");
                    }
                }
                case 5 -> {
                    System.out.println("Thank you for shopping come again soon");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}