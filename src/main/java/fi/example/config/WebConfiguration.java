package fi.example.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages="fi")
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    	registry.addViewController("/login").setViewName("login");
        registry.addViewController("/h2-console").setViewName("h2-console");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/user/").setViewName("kysely");
        registry.addViewController("/admin/").setViewName("lomakejson");
      
    }
    
    @Bean
    public ServletContextTemplateResolver templateResolver() {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
        resolver.setPrefix("/templates");
        resolver.setTemplateMode("HTML5");
        resolver.setOrder(1);
        return resolver;
    }
    

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/**");
    }

}