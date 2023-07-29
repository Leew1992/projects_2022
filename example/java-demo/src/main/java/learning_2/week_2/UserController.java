package learning_2.week_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("getObject")
    public Mono<String> getById(String id) {
        return userService.getById(id);
    }

    @GetMapping("listObjects")
    public Flux<String> listObjects() {
        return userService.listObjects();
    }

    @PostMapping("saveObject")
    public Mono<Void> saveObject(@RequestBody EntityObj obj) {
        Mono<EntityObj> entityObj = Mono.just(obj);
        return userService.saveObject(entityObj);
    }

}
