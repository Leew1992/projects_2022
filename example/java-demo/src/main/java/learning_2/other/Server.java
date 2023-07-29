package learning_2.other;

import learning_2.week_2.UserHandler;
import learning_2.week_2.UserService;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

public class Server {

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.createReactorServer();
        System.out.println("enter to exit!");
        System.in.read();
    }

    public RouterFunction<ServerResponse> routingFunction() {
        UserService service = new UserService();
        UserHandler handler = new UserHandler(service);
        return RouterFunctions.route(
            GET("getObject2/{id}").and(accept(APPLICATION_JSON)), handler::getById2)
                .andRoute(GET("listObjects2").and(accept(APPLICATION_JSON)), handler::listObjects2);
    }

    public void createReactorServer() throws Exception {
        RouterFunction<ServerResponse> router = routingFunction();
        HttpHandler handler = toHttpHandler(router);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);

        HttpServer server = HttpServer.create();
        server.handle(adapter).bindNow();
    }
}
