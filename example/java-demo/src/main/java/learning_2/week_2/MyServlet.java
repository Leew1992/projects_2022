package learning_2.week_2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

@WebServlet("/svr/")
public class MyServlet extends HttpServlet{

    private Map<String, BiConsumer<HttpServletRequest, HttpServletResponse>> routerMap = new HashMap<>();

    @Override
    public void init() throws ServletException {
        routerMap.put("test", this::test);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        resp.setCharacterEncoding("utf8");
        resp.setContentType("text/html");

        String route = req.getRequestURI().substring(5);

        BiConsumer<HttpServletRequest, HttpServletResponse> router = routerMap.get(route);

        if (router == null) {
            router = (request, response) -> System.out.println("no route to here");
        }

        router.accept(req, resp);
    }

    public String test(HttpServletRequest req, HttpServletResponse resp) {
        return "test";
    }
}
