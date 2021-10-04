package by.academy.web.app.listners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionListener implements HttpSessionAttributeListener {
    private static final Logger log = LoggerFactory.getLogger(SessionListener.class);
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        anyEvent(event, "added");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        anyEvent(event, "removed");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        anyEvent(event, "replaced");
    }

    private void anyEvent(HttpSessionBindingEvent event, String action) {
        if ("teacher".equals(event.getName())) {
            log.info("Teacher {} is added", event.getValue());
        }
    }
}
