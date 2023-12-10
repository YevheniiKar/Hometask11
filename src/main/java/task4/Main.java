package task4;
import java.util.Arrays;
import java.util.Random;
import java.util.Spliterator;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main {

    public static void main(String[] args) {
        long seed = 4987234982L;
        long a = 25214903917L;
        long c = 11L;
        long m = 1L << 48; // 2^48

        LongStream infiniteStream = createInfiniteStream(seed, a, c, m);

        // Convert LongStream to Stream<Long>
        Stream<Long> boxedStream = infiniteStream.boxed();

        // Use Spliterator to iterate over elements concurrently
        Spliterator<Long> spliterator = boxedStream.spliterator();
        Stream<Long> parallelStream = StreamSupport.stream(spliterator, true);

        // Print the first 10 numbers of the stream
        parallelStream.limit(10)
                .forEach(System.out::println);
    }

    private static LongStream createInfiniteStream(long seed, long a, long c, long m) {
        return LongStream.iterate(seed, x -> (a * x + c) % m);
    }
}