import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            String input = getInput(scanner); // Получаем ввод от пользователя
            String[] parts = parseInput(input); // Разбиваем ввод
            int num1 = Integer.parseInt(parts[0]);
            int num2 = Integer.parseInt(parts[2]);
            String operator = parts[1];

            checkValidNumbers(num1, num2); // Проверяем числа на допустимость

            int result = performOperation(num1, num2, operator); // Выполняем операцию

            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Получаем арифметическое выражение от пользователя
    private static String getInput(Scanner scanner) {
        System.out.println("Введите арифметическое выражение (например, 3 + 2):");
        return scanner.nextLine();
    }

    // Разбираем строку на компоненты
    private static String[] parseInput(String input) {
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Неверный формат ввода.");
        }
        return parts;
    }

    // Проверяем, что числа находятся в допустимом диапазоне
    private static void checkValidNumbers(int num1, int num2) {
        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new IllegalArgumentException("Числа должны быть от 1 до 10.");
        }
    }

    // Выполняем арифметическую операцию
    private static int performOperation(int num1, int num2, String operator) {
        int result;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Деление на ноль невозможно.");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Неверная операция. Поддерживаются только +, -, *, /.");
        }
        return result;
    }
}
