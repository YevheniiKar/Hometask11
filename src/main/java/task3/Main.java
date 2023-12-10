package task3;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1, 2, 0", "4, 5");
        List<Integer> numbers = sortedNumbers(list);
        for(Integer number: numbers) {
            System.out.print(number + " ");
        }
    }

    private static List<Integer> sortedNumbers(List<String> list) {
        return list.stream()
                .flatMap(str -> Arrays.stream(str.split(", ")))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }
}