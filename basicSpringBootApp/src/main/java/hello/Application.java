
package hello;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/*The @SpringBootApplication is an annotation that adds the following: 
@Configuration tags the class as a source of bean definitions for the application text

@EnableAutoConfiguration tells Spring Boot to start adding beans based on classpath settings, other beans and various
property settings

@EnableWebMvc

@ComponentScan tells spring to look for other components, configurations and services
*/
@SpringBootApplication
public class Application {
    
    /* Our Main class used to run the application*/
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
    
    
    /**/
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx){
        return args -> {
            System.out.println("Lets inspect the beans provided by Spring boot: ");
            /*Create a String array, fill it with ctx.getBeanDefinitionNames*/
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            /*Loop through our array*/
            for (String beanName: beanNames){
                System.out.println(beanName);
            }
        };
    }
}
