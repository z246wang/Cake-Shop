package listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.Type;
import service.TypeService;

/**
 * Application Lifecycle Listener implementation class ApplicationListener
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

    private static final String TYPE_LIST_ATTRIBUTE = "typeList";
    private TypeService tService;

    public void contextDestroyed(ServletContextEvent arg0)  { 
 
    }

    public void contextInitialized(ServletContextEvent arg0)  { 
        try {
            tService = new TypeService();
            List<Type> list = tService.selectAll();
            arg0.getServletContext().setAttribute(TYPE_LIST_ATTRIBUTE, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
