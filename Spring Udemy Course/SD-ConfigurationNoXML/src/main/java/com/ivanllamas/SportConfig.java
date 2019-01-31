
package com.ivanllamas;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;



/*Add the @Configuration Annotation. This tells spring that this is a Java Configuration, and to follow the rules
of a configuration file.*/

/*Add the @ComponentScan Annotation. Give the package that you want spring to start scannning (This is where all our 
@Components are at in this specific project), it will scan this package, and find all the classes that have @Component
and register them in the spring container. Instead of using an XML file, we're using a Java class instead
*/

/*We will run a demo on a main class JavaConfigDemo.java, where instead of using ClassPathXmlApplicationContext
we will use*/
@Configuration
@ComponentScan("com.ivanllamas") 
public class SportConfig {

}
