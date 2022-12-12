package servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/*
This method "hooks" us into the servlet context lifecycle. These methods are invoked once each
during the lifecycle of a servlet context. Note: The terms "Servlet Context" and "Servlet Container"
are the same thing.
 */
public class DependencyLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /*
        Do anything you might need to do before the server goes live in this method.
        This is analogous to a constructor.
        This method runs just after the context is constructed, and just before it goes into service.
        */
        System.out.println("server context start");

    }

    /*
    This is the opposite of init, destruction. This is analogous to the finalize() method.
    This method runs just after the context has stop servicing requests and before the objects get
    orphaned and garbage collected.
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("server context end");
    }
}