package task2;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ivan", "Alex", "Peter", "Nick", "Vasya", "Sasha");
        List<String> result = sortedUpperNames(names);
        System.out.println(result);
    }

    private static List<String> sortedUpperNames(List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}