package game.battle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class BattleLogger {

    private StringBuilder battleLog;

    public BattleLogger() {
        battleLog = new StringBuilder();
    }

    public void logAction(String action) {
        battleLog.append(action).append("\n");
    }

    public void saveToFile(String filename) {
        try {
            Files.write(Paths.get(filename), battleLog.toString().getBytes());
        } catch (IOException e) {
            System.out.println("Помилка при збереженні бою в файл: " + e.getMessage());
        }
    }

    public void replayBattleFromFile(String filename) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Помилка при читанні бою з файлу: " + e.getMessage());
        }
    }

    public void clearLog() {
        battleLog.setLength(0); // Очищення запису
    }

}
