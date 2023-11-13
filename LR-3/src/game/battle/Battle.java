package game.battle;

import game.Interface.Colors;
import game.droid.Droid;
import game.droid.boss.BossDroid;
import game.droid.hero.Regenix;
import game.droid.hero.Sniper;
import game.droid.hero.DocDroid;
import game.droid.hero.ShieldDroid;

import java.util.Random;
import java.util.Scanner;

public class Battle {
    private Scanner scanner = new Scanner(System.in);
    private static int droidCounter = 0;
    private BattleLogger logger = new BattleLogger();

    public void battle1vs1() {
        Droid droid1 = selectDroid();
        Droid droid2 = selectDroid();
        Random random = new Random();

        System.out.println(Colors.RED + "Ну що, у битву!");
        while (droid1.isAlive() && droid2.isAlive()) {
            if (random.nextBoolean()) {
                droid1.attack(droid2);
                logger.logAction(droid1.getName() + " атакує " + droid2.getName());
            } else {
                droid2.attack(droid1);
                logger.logAction(droid2.getName() + " атакує " + droid1.getName());
            }
        }

        if (droid1.isAlive()) {
            System.out.println(Colors.GREEN + droid1.getName() + " ПЕРЕМІГ ");
        } else {
            System.out.println(Colors.GREEN + droid2.getName() + " ПЕРЕМІГ ");
        }

        logger.saveToFile("battle.txt");
        logger.clearLog();
        droidCounter = 0;
    }

    public void battle3vs3() {
        Droid[] team1 = new Droid[3];
        Droid[] team2 = new Droid[3];
        System.out.println(Colors.BLUE + "Команда А: ");
        for (int i = 0; i < 3; i++) {
            team1[i] = selectDroid();
        }
        droidCounter = 0;
        System.out.println(Colors.BLUE + "Команда Б: ");
        for (int i = 0; i < 3; i++) {
            team2[i] = selectDroid();
        }

        Random random = new Random();
        System.out.println(Colors.YELLOW + "Команди готові! Нехай переможе сильніший, УПЕРЕД!");
        while (allMembersAlive(team1) && allMembersAlive(team2)) {
            for (int i = 0; i < 3; i++) {
                Droid target = team2[random.nextInt(3)];
                if (random.nextBoolean()) {
                    team1[i].attack(target);
                    logger.logAction(team1[i].getName() + " атакує " + target.getName());
                } else {
                    target = team1[random.nextInt(3)];
                    team2[i].attack(target);
                    logger.logAction(team2[i].getName() + " атакує " + target.getName());
                }
            }

            healTeammateIfPossible(team1);
            healTeammateIfPossible(team2);
        }

        if (allMembersAlive(team1)) {
            System.out.println(Colors.GREEN + "Команда 1 ВИГРАЛА!");
        } else {
            System.out.println(Colors.GREEN + "Команда 2 ВИГРАЛА!");
        }

        logger.saveToFile("battle.txt");
        logger.clearLog();
    }

    public void battle3vsBOSS() {
        Droid[] team = new Droid[3];
        System.out.println(Colors.BLUE + "Оберіть дроїдів для вашої команди:");
        for (int i = 0; i < 3; i++) {
            team[i] = selectDroid();
        }

        BossDroid boss = new BossDroid("BossName", 500, 20, 50, 0.2);

        while (allMembersAlive(team) && boss.isAlive()) {
            for (Droid droid : team) {
                if (droid.isAlive()) {
                    droid.attack(boss);
                    logger.logAction(droid.getName() + " атакує Боса");
                    if (boss.isAlive()) {
                        boss.attack(droid);
                        logger.logAction("Бос атакує " + droid.getName());
                    }
                }
            }

            healTeammateIfPossible(team);
        }
        if (allMembersAlive(team)) {
            System.out.println(Colors.GREEN + "Ваша команда ВИГРАЛА!");
        } else {
            System.out.println(Colors.GREEN + "БОС ВИГРАВ!");
        }

        logger.saveToFile("battle.txt");
        logger.clearLog();
    }


    private Droid selectDroid() {
        droidCounter++;
        System.out.println(Colors.YELLOW + "Oберіть " + droidCounter + "-го дроїда: \n" +
                "1 - SimpleDroid\n" +
                "2 - Sniper\n" +
                "3 - Regenix\n" +
                "4 - DocDroid\n" +
                "5 - ShieldDroid");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Назвіть його: ");
        String name = scanner.nextLine();

        switch (choice) {
            case 1:
                return new Droid(name, 100, 10);
            case 2:
                System.out.println("Введіть точність снайпера (наприклад, 80 для 80%):");
                double accuracy = scanner.nextDouble();
                return new Sniper(name, 100, 10, accuracy);
            case 3:
                System.out.println("Введіть кількість регенерації для Регенікса:");
                int regen = scanner.nextInt();
                return new Regenix(name, 100, 10, regen);
            case 4:
                System.out.println("Введіть кількість лікування для ЛікарДроїда:");
                int healAmount = scanner.nextInt();
                return new DocDroid(name, 100, 10, healAmount);
            case 5:
                System.out.println("Введіть шанс щита для ЩитДроїда (наприклад, 80 для 80%):");
                double shieldChance = scanner.nextDouble();
                System.out.println("Введіть пошкодження віддзеркалення для ЩитДроїда:");
                int reflectDamage = scanner.nextInt();
                return new ShieldDroid(name, 100, 10, shieldChance, reflectDamage);
            default:
                System.out.println("Неправильний вибір. Спробуйте знову.");
                return selectDroid();
        }
    }

    private boolean allMembersAlive(Droid[] team) {
        for (Droid droid : team) {
            if (!droid.isAlive()) {
                return false;
            }
        }
        return true;
    }

    private void healTeammateIfPossible(Droid[] team) {
        for (Droid droid : team) {
            if (droid instanceof DocDroid) {
                ((DocDroid) droid).teamHeal(team);
            }
        }
    }
}

