package by.academy.web.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Locale;

@WebFilter(filterName = "UpperCaseFilter", urlPatterns = "/*")
public class ParametersUpperCaseFilter extends AbstractFilter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ModifiableHttpServletRequest wrappedRequest = new ModifiableHttpServletRequest((HttpServletRequest) request);
        for (String s : wrappedRequest.getParameterNamesAsSet()) {
            wrappedRequest.setParameter(s, changeParameterToUpper(wrappedRequest, s));
        }
        chain.doFilter(wrappedRequest, response);
    }

    private String changeParameterToUpper(ModifiableHttpServletRequest wrappedRequest, String s) {
        return wrappedRequest.getParameter(s).toUpperCase(Locale.ROOT);
    }

}
