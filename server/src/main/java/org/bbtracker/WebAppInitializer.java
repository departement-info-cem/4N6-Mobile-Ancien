package org.bbtracker;

public class WebAppInitializer {}
//        implements WebApplicationInitializer {
//
//@Override
//public void onStartup(ServletContext servletContext) throws ServletException {
//    final AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//    context.setConfigLocation("com.myapp.config");
//
//    final FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("characterEncodingFilter", new CharacterEncodingFilter());
//    characterEncodingFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
//    characterEncodingFilter.setInitParameter("encoding", "UTF-8");
//    characterEncodingFilter.setInitParameter("forceEncoding", "true");
//
//    final FilterRegistration.Dynamic springSecurityFilterChain = servletContext.addFilter("springSecurityFilterChain", new DelegatingFilterProxy());
//    springSecurityFilterChain.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
//
//    servletContext.addListener(new ContextLoaderListener(context));
//    servletContext.setInitParameter("spring.profiles.default", "production");
//
//    final SpringServlet servlet = new SpringServlet();
//
//    final ServletRegistration.Dynamic appServlet = servletContext.addServlet("appServlet", servlet);
//    appServlet.setInitParameter("com.sun.jersey.config.property.packages", "com.myapp.api");
//    appServlet.setInitParameter("com.sun.jersey.spi.container.ContainerRequestFilters", "com.myapp.api.SizeLimitFilter");
//    appServlet.setLoadOnStartup(1);
//
//    final Set<String> mappingConflicts = appServlet.addMapping("/api/*");
//
//    if (!mappingConflicts.isEmpty()) {
//        throw new IllegalStateException("'appServlet' cannot be mapped to '/' under Tomcat versions <= 7.0.14");
//    }
//}