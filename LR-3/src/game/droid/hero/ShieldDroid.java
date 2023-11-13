package game.droid.hero;

import game.droid.Droid;

import java.util.Random;

public class ShieldDroid extends Droid {
    private double shieldChance; // шанс блокування
    private int reflectDamage;   // пошкодження віддзеркалення
    private Random random = new Random();

    public ShieldDroid(String name, int health, int damage, double shieldChance, int reflectDamage) {
        super(name, health, damage);
        this.shieldChance = shieldChance;
        this.reflectDamage = reflectDamage;
    }

    @Override
    public void takeDamage(int damage) {
        if ((shieldChance / 100) >= random.nextDouble()) {
            System.out.println(getName() + " заблокував атаку та віддзеркалив " + reflectDamage + " пошкодження назад!");
            setHealth(getHealth() + damage - reflectDamage); // спочатку додаємо пошкодження до здоров'я (бо блокуємо), а потім віднімаємо віддзеркалене пошкодження
        } else {
            super.takeDamage(damage);
        }
    }


    public double getShieldChance() {
        return shieldChance;
    }

    public void setShieldChance(double shieldChance) {
        this.shieldChance = shieldChance;
    }

    public int getReflectDamage() {
        return reflectDamage;
    }

    public void setReflectDamage(int reflectDamage) {
        this.reflectDamage = reflectDamage;
    }
    @Override
    public String getAbilities() {
        return super.getAbilities() + "\n" +
                "Шанс щита: " + getShieldChance() + "%\n" +
                "Пошкодження віддзеркалення: " + getReflectDamage();
    }

}
