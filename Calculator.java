import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение (например, 3 + 2):");

        try {
            // Чтение входной строки
            String input = scanner.nextLine();

            // Разбиение строки на компоненты (число, операция, число)
            String[] parts = input.split(" ");

            // Проверка, что введено ровно 3 части
            if (parts.length != 3) {
                throw new IllegalArgumentException("Неверный формат ввода.");
            }

            // Преобразование чисел в целые числа
            int num1 = Integer.parseInt(parts[0]);
            int num2 = Integer.parseInt(parts[2]);
            String operator = parts[1];

            // Проверка на допустимые числа (от 1 до 10)
            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                throw new IllegalArgumentException("Числа должны быть от 1 до 10.");
            }

            // Переменная для результата
            int result = 0;

            // Выполнение арифметической операции
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

            // Вывод результата
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
