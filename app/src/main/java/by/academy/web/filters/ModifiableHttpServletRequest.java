package by.academy.web.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ModifiableHttpServletRequest extends HttpServletRequestWrapper {

    private final ThreadLocal<Map<String, String[]>> parameterMap = new ThreadLocal<>();
    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request
     * @throws IllegalArgumentException if the request is null
     */
    public ModifiableHttpServletRequest(HttpServletRequest request) {
        super(request);
        parameterMap.set(new HashMap<>(request.getParameterMap()));
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return super.getParameterMap();
    }

    public void setParameter(String name, String value) {
        Map<String, String[]> map = parameterMap.get();
        map.put(name, new String[] {value});
    }


    @Override
    public String getParameter(String name) {
        return parameterMap.get().get(name)[0];
    }

    @Override
    public String[] getParameterValues(String name) {
        return parameterMap.get().get(name);
    }

    public Set<String> getParameterNamesAsSet() {
        return parameterMap.get().keySet();
    }
}
