
package com.ivanllamas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;



/*We will define our beans in this class. using the @Bean annotation.*/

@Configuration
//@ComponentScan("com.ivanllamas") //we manually created beans, don't need to scan for beans using component
@PropertySource("classpath:sport.properties")
public class SportConfig {

    //define bean for our sadfortuneservice, the id will be 'sadFortuneService' so we will name that as the method name
    @Bean
    public FortuneService sadFortuneService(){
    return new SadFortuneService();
    }
    //define bean for our swim coach AND inject dependency
    
    @Bean
    public Coach swimCoach(){
        //important to call the sadFortuneService method and match the name or ID
        return new SwimCoach(sadFortuneService());
    
    }
}
