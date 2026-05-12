import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Player player;
        Item item = new HealthPotion();
        Item item1 = new IronSword();
        Shop shop = new Shop();

        String[] enemyName = {"Kai", "Zara", "Rex", "Brutus", "Shadow", "Viper", "Golem", "Phantom", "Titan", "Ravage"};
        int round = 1;
        int classChoice;

        Scanner scanner = new Scanner(System.in);

        System.out.print("What is your name: ");
        String name = scanner.nextLine();



        System.out.println("1. Warrior");
        System.out.println("2. Mage");
        System.out.println("3. Archer");
        System.out.print("Enter your class choice: ");
        classChoice = scanner.nextInt();

        if (classChoice == 1){
            player = new Warrior(name);
        }

        else if (classChoice == 2) {
            player = new Mage(name);
        }

        else {
            player = new Archer(name);
        }

        System.out.print("Do you have a save? (yes/no): ");

        if (scanner.next().equalsIgnoreCase("Yes")){
            round = SaveSystem.load(player);
        }

        player.addItem(item);
        player.addItem(item1);

        while (player.isAlive()){
            System.out.println("-".repeat(10) + " Round " + round + " " + "-".repeat(10));

            Enemy enemy;

            if (round % 5 == 0){
                enemy = new Enemy(enemyName[(round - 1) % enemyName.length], round * 120, round * 120,  round * 18,  round * 8, round * 100, round * 100);
                enemy.isBoss = true;
            }
            else {
                enemy = new Enemy(enemyName[(round - 1) % enemyName.length], round * 80, round * 80,  round * 15,  round * 3, round * 50, round * 30);
            }

            BattleEngine battleEngine1 = new BattleEngine(player, enemy);
            battleEngine1.start();


            if (player.isAlive() && !battleEngine1.playerRun){
                player.currentHP = player.maxHp;
                shop.open(player);
                SaveSystem.save(player, round);
            }

            else if (battleEngine1.playerRun){
                System.out.println("You ran from " + enemy.name + " GAME OVER!");
                break;
            }
            round += 1;
        }
    }
}
