// Problem 1. The Health Bar
// Health can only change through takeDamage/heal, clamped between
// 0 and a final maxHealth fixed at creation.
// Note: this Character class shadows java.lang.Character within
// this file only, which is fine since we never use the built-in one here.

class Character {
    private int health;
    private final int maxHealth;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    void takeDamage(int amount) {
        health -= amount;
        if (health < 0) {
            health = 0;
        }
    }

    void heal(int amount) {
        health += amount;
        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    int getHealth() {
        return health;
    }
}

public class Problem1_HealthBar {
    public static void main(String[] args) {
        Character c = new Character(100);

        c.takeDamage(30);
        System.out.println("After takeDamage(30): health = " + c.getHealth());

        c.heal(50);
        System.out.println("After heal(50): health = " + c.getHealth());

        c.takeDamage(150);
        System.out.println("After takeDamage(150): health = " + c.getHealth());
    }
}
