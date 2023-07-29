package learning_2.week_2;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private Map<String, String> map = new HashMap<String, String>() {
        {
            put("1", "1");
            put("2", "2");
            put("3", "3");
        }
    };

    public Mono<String> getById(String id) {
        return Mono.justOrEmpty(map.get(id));
    }

    public Flux<String> listObjects() {
        return Flux.fromIterable(map.values());
    }

    public Mono<Void> saveObject(Mono<EntityObj> objMono) {
        return objMono.doOnNext(person -> {
            map.put(person.getKey(), person.getValue());
        }).thenEmpty(Mono.empty());
    }
}
