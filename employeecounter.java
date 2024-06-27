import java.util.Scanner;

public class EmployeeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите массив в формате [1, 0, 1, 1, 1]: ");
        String input = scanner.nextLine();

        // Удаляем квадратные скобки и пробелы, затем разделяем строку по запятым
        input = input.replace("[", "").replace("]", "").trim();
        String[] inputArray = input.split(",");

        int employeeCount = 0;

        // Проходим по массиву строк и считаем количество сотрудников
        for (String s : inputArray) {
            int value = Integer.parseInt(s.trim());
            if (value == 1) {
                employeeCount++;
            }
        }

        System.out.println("Количество сотрудников, зашедших на предприятие: " + employeeCount);
    }
}