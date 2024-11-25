package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo1 {
    public static void main(String[] args) {
        System.out.println("converting array objects to stream");
        List<Integer> list= Arrays.asList(4,12,7,9);
        Stream<Integer> values=list.stream().sorted();
        System.out.println("printing stream values");
        values.forEach(n -> System.out.println(n));
    }
}
