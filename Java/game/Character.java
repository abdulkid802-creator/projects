public abstract class Character {

    protected String name;
    protected int currentHP;
    protected int maxHp;
    protected int attackPower;
    protected int defence;
    protected int poisonTurns = 0;
    protected boolean isStunned = false;
    protected int burnTurns = 0;

    Character(String name, int currentHP, int maxHP, int attackPower, int defence){
        this.name = name;
        this.currentHP = currentHP;
        this.maxHp = maxHP;
        this.attackPower = attackPower;
        this.defence = defence;
    }

    void takeDamage(int damage){
        damage = Math.max(0, damage - defence);
        currentHP = Math.max(0, currentHP - damage);
        System.out.println(name + " took " + damage + " damage");
        System.out.println();
    }

    boolean isAlive(){
        return currentHP > 0;
    }

    void applyStatusEffects(){

        if (poisonTurns > 0){
            currentHP -= 5;
            System.out.println(name + " is Poisoned! (-5 HP)");
            poisonTurns -= 1;
        }
        if (burnTurns > 0){
            currentHP -= 8;
            defence -= 1;
            System.out.println(name + " is Burned! (-8 HP & -1 DEFENCE)");
            burnTurns -= 1;
        }
        if (isStunned){
            System.out.println("You are stun");
        }
    }

    abstract boolean attack(Character target);
}
