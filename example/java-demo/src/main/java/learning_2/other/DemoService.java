package learning_2.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class DemoService {

    @Autowired
    private DemoBean demoBean;

    public DemoBean getDemoBean() {
        return demoBean;
    }
}
