package com.wallmart.WallmartStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;




@SpringBootApplication
public class WallmartStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(WallmartStoreApplication.class, args);
	}

	@Bean
    public WebMvcConfigurer corsConfigurer() {                //COPIAR EN TODOS LOS PROYECTOS PARA EVITAR ERRORES DE CORS  (Cualquiera puede acceder a mi aplicacion)
        return new WebMvcConfigurer() {
            
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
                        
            }
        };
    }


}
