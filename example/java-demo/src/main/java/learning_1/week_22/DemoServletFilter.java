package learning_1.week_22;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "preFilter", urlPatterns = "/*")
public class DemoServletFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("DemoServletFilter init");
    }

    @Override
    public void destroy() {
        System.out.println("DemoServletFilter destroy");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("DemoServletFilter doFilter before");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("DemoServletFilter doFilter after");
    }
}
