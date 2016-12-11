package app.configuration;

import app.domain.factory.CameraFactory;
import app.domain.factory.PhotographerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * Created by cefothe on 11.12.16.
 */
@Configuration
public class JavaConfig {

    @Bean
    public CameraFactory cameraFactory(){
        return new CameraFactory();
    }

    @Bean
    public PhotographerFactory photographerFactory(){
        return new PhotographerFactory();
    }

}
