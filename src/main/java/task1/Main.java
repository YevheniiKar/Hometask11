package task1;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alex", "Ivan", "Nick", "Peter", "Vasya", "Sasha");
        String result = filteredNames(names);
        System.out.println(result);
    }

    private static String filteredNames(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(index -> index % 2 != 0)
                .mapToObj(index -> (index) + ". " + names.get(index) + ", ")
                .collect(Collectors.joining());
    }
}