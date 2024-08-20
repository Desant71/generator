import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LotteryNumberGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем диапазон чисел
        System.out.print("Введите минимальное число диапазона: ");
        int min = scanner.nextInt();
        System.out.print("Введите максимальное число диапазона: ");
        int max = scanner.nextInt();

        // Запрашиваем количество цифр в комбинации
        System.out.print("Введите количество цифр в выигрышной комбинации: ");
        int count = scanner.nextInt();

        // Генерируем выигрышную комбинацию
        int[] winningNumbers = generateWinningNumbers(min, max, count);

        // Выводим результат
        System.out.println("Ваша выигрышная комбинация: " + Arrays.toString(winningNumbers));

        scanner.close();
    }

    private static int[] generateWinningNumbers(int min, int max, int count) {
        Random random = new Random();
        int[] numbers = new int[count];

        for (int i = 0; i < count; i++) {
            // Генерируем уникальные числа
            int num;
            do {
                num = random.nextInt(max - min + 1) + min;
            } while (contains(numbers, num, i));
            numbers[i] = num;
        }

        return numbers;
    }

    private static boolean contains(int[] array, int value, int length) {
        for (int i = 0; i < length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }
}
