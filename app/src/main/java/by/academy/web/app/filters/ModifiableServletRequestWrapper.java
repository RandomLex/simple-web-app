package by.academy.web.app.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ModifiableServletRequestWrapper extends HttpServletRequestWrapper {

    private Map<String, String[]> ourParameterMap;

    /**
     * Constructs a request object wrapping the given request.
     * @param request
     * @throws IllegalArgumentException if the request is null
     */
    public ModifiableServletRequestWrapper(HttpServletRequest request) {
        super(request);
        ourParameterMap = new HashMap<>(request.getParameterMap());
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return ourParameterMap;
    }

    @Override
    public String getParameter(String name) {
        return ourParameterMap.get(name)[0];
    }

    public void setParameter(String name, String value) {
        ourParameterMap.put(name, new String[] {value});
    }

    @Override
    public String[] getParameterValues(String name) {
        return super.getParameterValues(name);
    }

    public Set<String> getParameterNamesAsSet() {
        return ourParameterMap.keySet();
    }
}
