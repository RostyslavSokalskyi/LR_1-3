package game.droid;

import game.Interface.Colors;

public class Droid {
    private String name;
    private int health;
    private int damage;
    private final int maxHealth = 100; // Максимальне здоров'я для базового дроїда

    public Droid(String name, int health, int damage) {
        this.name = name;
        setHealth(health); // Використано сетер для правильної валідації
        this.damage = damage;
    }

    public void attack(Droid target) {
        System.out.println(Colors.RED + this.getName() + " атакує " + target.getName() + " та наносить " + this.getDamage() + " пошкоджень.");
        target.takeDamage(this.getDamage());
    }

    public void takeDamage(int damage) {
        setHealth(this.getHealth() - damage); // Використано сетер для правильної валідації
        //  System.out.println(this.getName() + " отримав " + damage + " пошкоджень.");
    }


    public boolean isAlive() {

        return (this.health > 0);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health > 100) {
            this.health = 100;
        } else if (health < 0) {
            this.health = 0;
        } else {
            this.health = health;
        }
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public String getAbilities() {
        return Colors.BLUE +
                "Ім'я: " + getName() + "\n" +
                "Здоров'я: " + getHealth() + "/" + getMaxHealth() + "\n" +
                "Пошкодження: " + getDamage();
    }

}
