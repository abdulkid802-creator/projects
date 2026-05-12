import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class SaveSystem {

    static void save(Player player, int round){
        try {
            FileWriter writer = new FileWriter("save.txt");
            writer.write(player.name + "\n" + player.level + "\n" + player.exp + "\n" + player.coins + "\n"
                    + player.currentHP + "\n" + player.maxHp + "\n" + player.attackPower + "\n" + player.defence + "\n"
                    + round + "\n");
            for (Item item : player.inventory.items) {
                writer.write(item.getName() + "\n");
            }
            writer.write("END\n"); // marks end of items
            writer.close();
            System.out.println("Game saved");
        } catch (IOException e) {
            System.out.println("Could not save game!");
        }
    }
    static int load(Player player){
        try {
            File file = new File("save.txt");
            Scanner reader = new Scanner(file);
            player.name = reader.nextLine();
            player.level = Integer.parseInt(reader.nextLine());
            player.exp = Integer.parseInt(reader.nextLine());
            player.coins = Integer.parseInt(reader.nextLine());
            player.currentHP = Integer.parseInt(reader.nextLine());
            player.maxHp = Integer.parseInt(reader.nextLine());
            player.attackPower = Integer.parseInt(reader.nextLine());
            player.defence = Integer.parseInt(reader.nextLine());
            int round = Integer.parseInt(reader.nextLine());
            String itemLine = reader.nextLine();

            while (!itemLine.equals("END")) {
                switch (itemLine) {
                    case "Health Potion" -> player.addItem(new HealthPotion());
                    case "Elixir" -> player.addItem(new Elixir());
                    case "Iron Sword" -> player.addItem(new IronSword());
                    case "Shield" -> player.addItem(new Shield());
                    case "War Axe" -> player.addItem(new WarAxe());
                    case "Heavy Armour" -> player.addItem(new HeavyArmour());
                    case "Spell Tome" -> player.addItem(new SpellTome());
                    case "Mana Crystal" -> player.addItem(new ManaCrystal());
                    case "Poison Arrow" -> player.addItem(new PoisonArrow());
                    case "Speed Boots" -> player.addItem(new SpeedBoots());
                }
                itemLine = reader.nextLine();
            }
            reader.close();
            return round;
        } catch (Exception e) {
            System.out.println("No save file found!");
            return 1;
        }
    }
}
