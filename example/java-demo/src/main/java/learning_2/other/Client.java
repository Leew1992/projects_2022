package learning_2.other;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class Client {

    public static void main(String[] args) {
        WebClient client = WebClient.create("http://127.0.0.1:57677");
        String res1 = client.get().uri("getObject2/1").accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToMono(String.class).block();
        System.out.println(res1);

        Flux<String> res2 = client.get().uri("listObjects2").accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToFlux(String.class);
        res2.map(x -> x.toString()).buffer().doOnNext(System.out::println).blockFirst();
    }
}
