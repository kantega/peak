package vis.servlet.lifecycle;

import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServlet;

public class Register
{

    public static void filter(ServletContextEvent event, Filter filter, String path){
        FilterRegistration registration = event.getServletContext().addFilter(filter.getClass().getName(),filter);
        registration.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class),true,path);
    }

    public static void servlet(ServletContextEvent event, HttpServlet servlet, String path){
        ServletRegistration registration = event.getServletContext().addServlet(servlet.getClass().getName(),servlet);
        registration.addMapping(path);
    }
}
