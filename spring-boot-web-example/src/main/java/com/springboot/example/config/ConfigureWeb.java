package com.springboot.example.config;

import com.springboot.example.servlet.CustomServlet;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Configuration
public class ConfigureWeb implements ServletContextInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic serviceServlet = servletContext.addServlet("ServiceConnect", new CustomServlet());

        serviceServlet.addMapping("/custom");
        serviceServlet.setAsyncSupported(true);
        serviceServlet.setLoadOnStartup(1);
    }
}
