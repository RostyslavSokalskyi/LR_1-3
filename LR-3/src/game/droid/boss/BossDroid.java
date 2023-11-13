package game.droid.boss;

import game.droid.Droid;

import java.util.Random;

public class BossDroid extends Droid {
    private int specialAttackDamage;
    private double specialAttackChance;
    private Random random = new Random();

    public BossDroid(String name, int health, int damage, int specialAttackDamage, double specialAttackChance) {
        super(name, health, damage);
        this.specialAttackDamage = specialAttackDamage;
        this.specialAttackChance = specialAttackChance;
    }

    @Override
    public String getAbilities() {
        return super.getAbilities() + "\n" +
                "Пошкодження спеціальної атаки: " + getSpecialAttackDamage() + "\n" +
                "Шанс спеціальної атаки: " + getSpecialAttackChance() + "%";
    }



    @Override
    public void attack(Droid target) {
        if (random.nextDouble() <= specialAttackChance) {
            System.out.println(getName() + " використовує спеціальну атаку проти " + target.getName() + " та наносить " + specialAttackDamage + " пошкоджень.");
            target.takeDamage(specialAttackDamage);
        } else {
            System.out.println(getName() + " атакує " + target.getName() + " та наносить " + getDamage() + " пошкоджень.");
            super.attack(target);
        }
    }


    public int getSpecialAttackDamage() {
        return specialAttackDamage;
    }

    public void setSpecialAttackDamage(int specialAttackDamage) {
        this.specialAttackDamage = specialAttackDamage;
    }

    public double getSpecialAttackChance() {
        return specialAttackChance;
    }

    public void setSpecialAttackChance(double specialAttackChance) {
        this.specialAttackChance = specialAttackChance;
    }
}
