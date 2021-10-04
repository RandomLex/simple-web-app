package by.academy.web.app.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Locale;

@WebFilter(filterName = "UpperCaseFilter", urlPatterns = "/*")
public class UpperCaseFilter extends AbstractFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ModifiableServletRequestWrapper requestWrapper = new ModifiableServletRequestWrapper((HttpServletRequest) request);
        for (String key : requestWrapper.getParameterNamesAsSet()) {
            requestWrapper.setParameter(key, toUpperCase(request, key));
        }
        chain.doFilter(requestWrapper, response);
    }

    private String toUpperCase(ServletRequest request, String key) {
        return request.getParameter(key).toUpperCase(Locale.ROOT);
    }
}
