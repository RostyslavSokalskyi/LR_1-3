/**
 * Клас для визначення послідовності чисел Люка.
 */
public class LucasSequence {

    private int n;   // Кількість чисел для обчислення
    private long var;

    /**
     * Конструктор класу LucasSequence.
     * @param n кількість чисел, яку потрібно обчислити
     */
    LucasSequence(int n) {
        this.n = n;
    }

    /**
     * Обчислює суму квадратів перших n чисел Люка.
     * @return сума квадратів чисел
     */
    public long sumSquares() {
        long result = 1;
        long prev = 1, curr = 3;
        if (n == 0) {
            System.out.println("До суми не включено жодного числа");
            return 0;
        } else if (n == 1) {
            System.out.println("До суми включено лише одне число, квадрат якого рівний 1");
            return 1;
        } else {
            for (int i = 0; i <= n - 2; i++) {
                var = curr + prev;
                result += curr * curr;
                prev = curr;
                curr = var;
            }
            System.out.printf("Сума квадратів перших %d чисел Люка дорівнює %d", n, result);
        }
        return result;
    }
}
