package it.onyx.assicurazioni.configuration;

import it.onyx.assicurazioni.interceptor.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private UserInterceptor userInterceptor; // Spring inietta il tuo interceptor

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Applica l'interceptor a tutte le rotte dell'applicazione
        registry.addInterceptor(userInterceptor).addPathPatterns("/**");
    }
}
