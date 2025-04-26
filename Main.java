import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        // Создаем сканер для считывания данных с консоли
        Scanner scanner = new Scanner(System.in);

        // Бесконечный цикл, чтобы пользователь мог вводить несколько выражений
        while (true) {
            try {
                // Просим пользователя ввести выражение
                System.out.println("Введите арифметическое выражение (или 'exit' для выхода):");
                String input = scanner.nextLine();

                // Выход из программы, если введено 'exit'
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Выход из программы.");
                    break;
                }

                // Вычисляем результат для введенного выражения
                String result = calc(input);

                // Выводим результат
                System.out.println("Результат: " + result);
            } catch (CalculatorException e) {
                System.out.println("Ошибка: " + e.getMessage()); // Если ошибка, выводим сообщение об ошибке
            }
        }

        // Закрываем сканер
        scanner.close();
    }

    // Метод для обработки ввода
    public static String calc(String input) throws CalculatorException {
        // Разбираем ввод на три части: два числа и оператор
        String[] parts = input.trim().split(" ");

        if (parts.length != 3) {
            throw new CalculatorException("Неверный формат ввода. Ожидается: число оператор число.");
        }

        String strNum1 = parts[0];
        String operator = parts[1];
        String strNum2 = parts[2];

        // Преобразуем строки в числа
        int num1 = parseNumber(strNum1);
        int num2 = parseNumber(strNum2);

        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new CalculatorException("Числа должны быть от 1 до 10 включительно.");
        }

        // Выполнение операции
        int result = ArithmeticOperation.performOperation(num1, num2, operator);

        return String.valueOf(result);
    }

    // Метод для обработки чисел и их преобразования
    private static int parseNumber(String str) throws CalculatorException {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new CalculatorException("Неверный формат числа: " + str);
        }
    }
}
class ArithmeticOperation {
    public static int performOperation(int num1, int num2, String operator) throws CalculatorException {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new CalculatorException("Деление на ноль невозможно.");
                }
                return num1 / num2; // целочисленное деление
            default:
                throw new CalculatorException("Неизвестный оператор: " + operator);
        }
    }
}
// Пользовательское исключение для калькулятора
class CalculatorException extends Exception {
    public CalculatorException(String message) {
        super(message);
    }
}
