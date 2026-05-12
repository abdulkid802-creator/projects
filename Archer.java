public class Archer extends Player{

    Archer(String name){
        super(name);
        this.maxHp = 115;
        this.currentHP = 115;
        this.defence = 7;
        this.attackPower = 28;
    }

    @Override
    boolean specialAbility(Character target){

        if (cooldown == 0){
            System.out.println("🏹Aimed Shot!");
            target.takeDamage(attackPower * 2);
            target.poisonTurns = 3;
            System.out.println("Enemy is poisoned!");
            cooldown = 2;
            return true;
        }
        else {
            System.out.println("Ability on cooldown! (" + cooldown + " turns remaining)");
        }
        return false;
    }
}
