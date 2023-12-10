package task5;
import java.util.Spliterator;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> stream2 = Stream.of(6, 7, 8, 9, 10);

        Stream<Integer> zippedStream = zip(stream1, stream2);

        zippedStream.forEach(System.out::println);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Stream.Builder<T> result = Stream.builder();

        Spliterator<T> firstSplit = first.spliterator();
        Spliterator<T> secondSplit = second.spliterator();

        long size = Math.min(firstSplit.estimateSize(), secondSplit.estimateSize());

        for (long i = 0; i < size; i++) {
            if (firstSplit.tryAdvance(result::add)) {
                secondSplit.tryAdvance(t -> {});
            } else {
                break;
            }
        }

        return result.build();
    }
}