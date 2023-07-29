package learning_2.week_2;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

public class UserHandler {

    private UserService userService;

    public UserHandler(UserService service) {
        this.userService = service;
    }

    public Mono<ServerResponse> getById2(ServerRequest request) {
        String id = request.pathVariable("id");
        Mono<String> result = userService.getById(id);

        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        return result.flatMap(person -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(fromObject(person)).switchIfEmpty(notFound));

        // return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(result)).switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> listObjects2(ServerRequest request) {
        Flux<String> result = userService.listObjects();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(result, String.class);
    }

    public Mono<ServerResponse> saveObject2(ServerRequest request) {
        Mono<EntityObj> obj = request.bodyToMono(EntityObj.class);
        return ServerResponse.ok().build(userService.saveObject(obj));
    }
}
