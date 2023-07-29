package learning_2.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @Autowired
    private DemoService demoService1;

    @RequestMapping("/test")
    public String test() {
        System.out.println(demoService);
        System.out.println(demoService1);
        return "OK";
    }
}
