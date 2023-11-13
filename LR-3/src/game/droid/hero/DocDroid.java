package game.droid.hero;

import game.droid.Droid;

public class DocDroid extends Droid {
    private int healAmount;
    private static final int HEALTH_THRESHOLD = 50;

    public DocDroid(String name, int health, int damage, int healAmount) {
        super(name, health, damage);
        this.healAmount = healAmount;
    }

    @Override
    public void attack(Droid target) {
        if (this.getHealth() <= HEALTH_THRESHOLD) {
            System.out.println(getName() + " вирішив вилікувати себе.");
            this.heal(this);
        } else {
            System.out.println(getName() + " атакує " + target.getName() + " та наносить " + getDamage() + " пошкоджень.");
            super.attack(target);
        }
    }

    @Override
    public String getAbilities() {
        return super.getAbilities() + "\n" +
                "Кількість лікування: " + getHealAmount();
    }


    public void heal(Droid droid) {
        int newHealth = droid.getHealth() + healAmount;
        droid.setHealth(Math.min(newHealth, droid.getMaxHealth()));
        System.out.println(this.getName() + " вилікував " + droid.getName() + " на " + healAmount + " од. здоров'я.");
    }

    // У режимі 3x3 або 3xBoss
    public void teamHeal(Droid[] teamMates) {
        Droid leastHealthyDroid = null;
        int lowestHealth = Integer.MAX_VALUE;

        for (Droid droid : teamMates) {
            if (droid.getHealth() < lowestHealth) {
                leastHealthyDroid = droid;
                lowestHealth = droid.getHealth();
            }
        }

        if (leastHealthyDroid != null) {
            heal(leastHealthyDroid);
        }
    }

    public int getHealAmount() {
        return healAmount;
    }

    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }
}
