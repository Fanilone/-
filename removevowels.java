import java.util.Scanner;

public class RemoveVowels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрос ввода строки
        System.out.println("Введите строку: ");
        String input = scanner.nextLine();

        // Вызов функции удаления гласных
        String result = removeVowels(input);

        // Вывод результата
        System.out.println("Результат: " + result);
    }

    public static String removeVowels(String input) {
        // Определяем строку, содержащую все гласные на русском и английском языках
        String vowels = "AEIOUaeiouАЕЁИОУЫЭЮЯаеёиоуыэюя";

        // Создаем StringBuilder для формирования результата
        StringBuilder result = new StringBuilder();

        // Проходим по каждому символу входной строки
        for (char c : input.toCharArray()) {
            // Если символ не является гласной, добавляем его в результат
            if (vowels.indexOf(c) == -1) {
                result.append(c);
            }
        }

        // Возвращаем строку без гласных
        return result.toString();
    }
}