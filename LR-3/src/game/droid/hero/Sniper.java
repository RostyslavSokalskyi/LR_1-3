package game.droid.hero;

import game.droid.Droid;

import java.util.Random;

public class Sniper extends Droid {

    private double accuracy; //точність попадання персонажа
    private Random random = new Random();

    public Sniper(String name, int health, int damage, double accuracy) {
        super(name, health, damage);
        setAccuracy(accuracy); // Використано сетер для валідації
    }

    @Override
    public void attack(Droid target) {
        if (random.nextDouble() <= getAccuracy() / 100.0) { // визначення, чи буде удар успішним
            System.out.println(this.getName() + " успішно атакує " + target.getName() + " та наносить " + this.getDamage() + " пошкоджень.");
            target.takeDamage(this.getDamage());
        } else {
            System.out.println(this.getName() + " промахнувся!");
        }
    }


    public double getAccuracy() {
        return accuracy;
    }
    @Override
    public String getAbilities() {
        return super.getAbilities() + "\n" +
                "Точність: " + getAccuracy() + "%";
    }

    public void setAccuracy(double accuracy) {
        // Валідація для точності. Вона повинна бути від 0 до 100.
        if (accuracy < 0.0) {
            this.accuracy = 0.0;
        } else if (accuracy > 100.0) {
            this.accuracy = 100.0;
        } else {
            this.accuracy = accuracy;
        }
    }
}
