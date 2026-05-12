public class Enemy extends Character{

    int coinReward;
    int xpReward;
    int turnCount = 0;
    boolean isBoss = false;

    Enemy(String name, int currentHP, int maxHP, int attackPower, int defence, int xpReward, int coinReward){
        super(name, currentHP, maxHP, attackPower,defence);
        this.xpReward = xpReward;
        this.coinReward = coinReward;
    }

    @Override
    boolean attack(Character target){
        System.out.println(name + " is attacking " + target.name);

        if (isBoss && turnCount % 2 == 0){
            System.out.println("💀Boss Special Move!");
            target.takeDamage(attackPower * 2);
        }
        else {
            target.takeDamage(attackPower);
        }
        turnCount += 1;
        return true;
    }

    void randomAttack(){

    }
}
