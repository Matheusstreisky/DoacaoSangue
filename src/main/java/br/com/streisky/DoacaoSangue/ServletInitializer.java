package br.com.streisky.DoacaoSangue;

import com.sun.faces.config.ConfigureListener;
import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ServletInitializer extends SpringBootServletInitializer implements ServletContextAware {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DoacaoSangueApplication.class);
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
    }

    @Bean
    public FacesServlet facesServlet() {
        return new FacesServlet();
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean registration = new ServletRegistrationBean<>(new FacesServlet(), "*.xhtml");
        registration.setLoadOnStartup(1);
        return registration;
    }

    @Bean
    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
        return new ServletListenerRegistrationBean<>(new ConfigureListener());
    }

    @Bean
    public ServletContextInitializer servletContextInitializer() {

        return sc -> {
            sc.addListener(com.sun.faces.config.ConfigureListener.class);
            sc.setInitParameter("com.sun.faces.expressionFactory", "com.sun.el.ExpressionFactoryImpl");
            sc.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
            sc.setInitParameter("facelets.DEVELOPMENT", Boolean.TRUE.toString());
            sc.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
            sc.setInitParameter("javax.faces.FACELETS_LIBRARIES", "springsecurity.taglib.xml");
            sc.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "1");
            sc.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Boolean.TRUE.toString());
            sc.setInitParameter("javax.faces.PARTIAL_STATE_SAVING_METHOD", Boolean.TRUE.toString());
            sc.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
            sc.setInitParameter("javax.faces.STATE_SAVING_METHOD", "server");
            sc.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", Boolean.TRUE.toString());
            sc.setInitParameter("primefaces.FONT_AWESOME", Boolean.TRUE.toString());
        };
    }
}
