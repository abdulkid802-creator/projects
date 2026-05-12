public class Mage extends Player{

    Mage(String name){
        super(name);
        this.maxHp = 120;
        this.currentHP = 120;
        this.defence = 5;
        this.attackPower = 40;
    }

    @Override
    boolean attack(Character target){
        System.out.println(name + " is attacking " + target.name);
        int roll = rand.nextInt(10);

        if (roll == 0){
            System.out.println("Critical hit!");
            target.takeDamage(attackPower * 2);
            return true;
        }
        else {
            target.takeDamage(attackPower);
        }
        return true;
    }

    @Override
    boolean specialAbility(Character target){

        if (cooldown == 0){
            System.out.println("🔥Fireball!");
            target.takeDamage(attackPower * 4);
            target.burnTurns = 3;
            System.out.println("Enemy is burning!");
            cooldown = 4;
            return true;
        }
        else {
            System.out.println("Ability on cooldown! (" + cooldown + " turns remaining)");
        }
        return false;
    }
}
