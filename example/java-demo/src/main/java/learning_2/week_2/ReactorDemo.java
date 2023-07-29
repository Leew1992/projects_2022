package learning_2.week_2;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ReactorDemo {

    public static void main(String[] args) {
        Flux.just(1,2,3,4).subscribe(System.out::print);
        System.out.println();
        Mono.just(1).subscribe(System.out::print);

//        List<Integer> items = Arrays.asList(1,2,3,4);
//        Flux.fromArray(items.toArray());
//
//        Flux.fromStream(items.stream());


    }
}
