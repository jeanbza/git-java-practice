import java.util.Arrays;

/**
 * Created by jadekler on 1/12/15.
 */
public class Streams {
    public static void main(String[] args) {
        Arrays.asList("a1", "a2", "a3")
            .stream()
            .findFirst()
            .ifPresent(System.out::println);
    }
}
