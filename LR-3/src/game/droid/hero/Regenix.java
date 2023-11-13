package game.droid.hero;

import game.droid.Droid;

public class Regenix extends Droid {
    private int regenirationAmount;

    public Regenix(String name, int health, int damage, int regenirationAmount) {
        super(name, health, damage);
        this.regenirationAmount = regenirationAmount;
    }

    public void regenerate() {
        if (!isAlive()) return; // якщо дроїд помер, то він не може регенервувати здоров'я

        // Оптимізована логіка регенерації з урахуванням максимального значення здоров'я
        int newHealth = this.getHealth() + getRegenirationAmount();
        setHealth(Math.min(newHealth, getMaxHealth()));
    }

    @Override
    public void attack(Droid target) {
        System.out.println(getName() + " атакує " + target.getName() + " та наносить " + getDamage() + " пошкоджень.");
        super.attack(target);
        System.out.println(getName() + " регенерує " + getRegenirationAmount() + " од. здоров'я.");
        this.regenerate();
    }


    public int getRegenirationAmount() {
        return regenirationAmount;
    }

    @Override
    public String getAbilities() {
        return super.getAbilities() + "\n" +
                "Кількість регенерації: " + getRegenirationAmount();
    }

    public void setRegenirationAmount(int regenirationAmount) {
        this.regenirationAmount = regenirationAmount;
    }

    // Додано метод, щоб встановити максимальне значення здоров'я, яке може бути у дроїда
    public int getMaxHealth() {
        return 100;
    }
}

