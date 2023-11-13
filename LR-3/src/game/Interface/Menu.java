package game.Interface;

import game.battle.Battle;
import game.droid.Droid;
import game.droid.hero.DocDroid;
import game.droid.hero.Regenix;
import game.droid.hero.ShieldDroid;
import game.droid.hero.Sniper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public void menu() {
        System.out.println(Colors.YELLOW + "Оберіть варіант гри:\n" +
                "1 - 1v1\n" +
                "2 - 3v3\n" +
                "3 - 3vBOSS\n" +
                "4 - Переглянути характеристки дроїдів\n" +
                "5 - Вийти");

        int choice = getChoice();
        Battle battle = new Battle();

        switch (choice) {
            case 1 -> battle.battle1vs1();
            case 2 -> battle.battle3vs3();
            case 3 -> battle.battle3vsBOSS();
            case 4 -> showDroidAbilities();
            case 5 -> {
                System.out.println(Colors.YELLOW + "До побачення!");
                System.exit(0);
            }
        }

    }

    public void showDroidAbilities() {
        System.out.println("Оберіть дроїда для перегляду його характеристик:");
        System.out.println("1 - SimpleDroid\n" +
                "2 - Sniper\n" +
                "3 - Regenix\n" +
                "4 - DocDroid\n" +
                "5 - ShieldDroid");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        Droid dummyDroid;
        switch (choice) {
            case 1:
                dummyDroid = new Droid("Sample", 100, 10);
                break;
            case 2:
                dummyDroid = new Sniper("Sample", 100, 10, 80);
                break;
            case 3:
                dummyDroid = new Regenix("Sample", 100, 10, 10);
                break;
            case 4:
                dummyDroid = new DocDroid("Sample", 100, 10, 15);
                break;
            case 5:
                dummyDroid = new ShieldDroid("Sample", 100, 10, 80, 10);
                break;
            default:
                System.out.println("Невірний вибір. Спробуйте знову.");
                return;
        }

        System.out.println(dummyDroid.getAbilities());
    }

    public int getChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean validChoice = false;

        while (!validChoice) {
            try {
                choice = scanner.nextInt();
                if (choice > 0 && choice < 5) {
                    validChoice = true;
                } else {
                    System.out.println("Будь ласка, введіть число від 1 до 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Будь ласка, введіть коректне число.");
                scanner.next();  // clear invalid input
            }
        }

        return choice;
    }
}

