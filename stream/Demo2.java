package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo2 {
    public static void main(String[] args) {
        System.out.println("demosntarting map in stream api");
        List<Integer> list= Arrays.asList(9,12,1,45,3,76,5);
        System.out.println(list);
        System.out.println("multpying each value by 2 using map in stream api");
        Stream<Integer> stream = list.stream().sorted().map(num -> num * 2);
        stream.forEach(n->System.out.print(n+" "));
    }
}
