import java.util.Scanner;

/**
 * Головний клас Main, що починає роботу програми.
 */
public class Main {

    /**
     * Головний метод програми.
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        System.out.print("Суму квадратів скількох перших " +
                "чисел Люка ви хочете визначити? ");

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        LucasSequence luke = new LucasSequence(n);
        luke.sumSquares();
    }
}
