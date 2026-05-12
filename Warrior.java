public class Warrior extends Player{

    Warrior(String name){
        super(name);
        this.maxHp = 150;
        this.currentHP = 150;
        this.defence = 8;
        this.attackPower = 18;
    }

    @Override
    boolean specialAbility(Character target){

        if (cooldown == 0){
            System.out.println("Shield Bash!");
            target.takeDamage(attackPower);
            target.attackPower -= 5;
            target.isStunned = true;
            System.out.println("Enemy is stunned!");
            cooldown = 3;
            return true;
        }
        else {
            System.out.println("Ability on cooldown! (" + cooldown + " turns remaining)");
        }
        return false;
    }
}
