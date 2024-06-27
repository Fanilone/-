import java.util.ArrayList;
import java.util.List;

public class BestSum {
    public static void main(String[] args) {
        List<Integer> distances = List.of(50, 55, 57, 58, 60);
        int maxDistance = 175;
        int citiesToVisit = 3;

        List<Integer> bestCombination = chooseBestSum(maxDistance, citiesToVisit, distances);
        if (bestCombination != null) {
            System.out.println("Города с максимальной суммой расстояний: " + bestCombination);
            System.out.println("Максимальная сумма расстояний: " + bestCombination.stream().mapToInt(Integer::intValue).sum());
        } else {
            System.out.println("Нет доступных комбинаций.");
        }
    }

    public static List<Integer> chooseBestSum(int t, int k, List<Integer> ls) {
        List<List<Integer>> combinations = new ArrayList<>();
        generateCombinations(ls, k, 0, new ArrayList<>(), combinations);

        List<Integer> bestCombination = null;
        int bestSum = 0;

        for (List<Integer> combination : combinations) {
            int sum = combination.stream().mapToInt(Integer::intValue).sum();
            if (sum <= t && (bestCombination == null || sum > bestSum)) {
                bestCombination = combination;
                bestSum = sum;
            }
        }

        return bestCombination;
    }

    private static void generateCombinations(List<Integer> ls, int k, int start, List<Integer> current, List<List<Integer>> combinations) {
        if (current.size() == k) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < ls.size(); i++) {
            current.add(ls.get(i));
            generateCombinations(ls, k, i + 1, current, combinations);
            current.remove(current.size() - 1);
        }
    }
}
