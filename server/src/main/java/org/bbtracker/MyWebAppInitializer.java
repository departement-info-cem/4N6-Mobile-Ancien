package org.bbtracker;


public class MyWebAppInitializer {}
//        implements WebApplicationInitializer {
//    @Override
//    public void onStartup(ServletContext container) {
//        XmlWebApplicationContext context = new XmlWebApplicationContext();
//        context.setConfigLocation("/WEB-INF/spring/dispatcher-config.xml");
//
//        ServletRegistration.Dynamic dispatcher = container
//          .addServlet("dispatcher", new DispatcherServlet(context));
//
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/");
//    }
//}