package game.main;

import game.Interface.Colors;
import game.Interface.Menu;
import game.battle.BattleLogger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        BattleLogger logger = new BattleLogger();

        boolean gameRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (gameRunning) {
            System.out.println(Colors.YELLOW + "Виберіть опцію:");
            System.out.println("1. Розпочати нову гру");
            System.out.println("2. Переглянути останній записаний бій");
            System.out.println("3. Вийти з гри");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline

            switch (choice) {
                case 1:
                    menu.menu();
                    break;
                case 2:
                    logger.replayBattleFromFile("battle.txt");
                    break;
                case 3:
                    gameRunning = false;
                    break;
                default:
                    System.out.println(Colors.RED + "Будь ласка, введіть правильний номер опції.");
            }
        }

        System.out.println(Colors.YELLOW + "Дякуємо за гру!");
        scanner.close();
    }
}
