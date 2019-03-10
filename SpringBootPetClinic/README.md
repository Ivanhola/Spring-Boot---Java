# Documentation for this Spring Boot Pet Clinic

__Spring Boot Pet Clinic__ is a project that is often used by the _Spring_ team, as a complete _reference project_ to the technologies that the Spring Framework has to offer, as well as 
the general structure and best practices to creating a Spring application. 

In this project, we will create our own __Pet Clinic__ and this will be our general purpose
reference project that integrates the use cases of general purpose Spring Framework technologies.

This project is built in a __Multi Module__ Maven format where we will split up the project into modules that contain [_data for our database interactions_](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/SpringBootPetClinic/pet-clinic-data)
and data displayed on the [_web browser_](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/SpringBootPetClinic/pet-clinic-web).

### Technologies:
- Java (Interfaces, OOP, Entity, Database)
- Spring Framework (Spring Boot, Spring Data JPA, Spring MVC)
- MySql
- H2 Database
- Maven (_Multi Module Model_)
- Thymeleaf
- RESTful Web Services
- Hibernate
- Lombok

## Maven Multi Module Structure

This Spring Boot project is Broken up into 2 different Maven Modules (Maven Projects) that handle different tasks, primarily the [__Pet Clinic Data__](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/SpringBootPetClinic/pet-clinic-data) takes care of the _Backend Database Interactions_ and the [__Pet Clinic Web__](https://github.com/Ivanhola/Spring-Framework-Course-Learning/blob/master/SpringBootPetClinic/pet-clinic-web) takes care of the _Web portion_ of the program.


#### Creating a Module Maven Project

[Parent Maven file](https://github.com/Ivanhola/Spring-Framework-Course-Learning/blob/master/SpringBootPetClinic/pom.xml)
```xml

    <!-- Make it into a Maven Module project-->
    <packaging>pom</packaging>
    <!-- Add your modules -->
    <modules>
        <module>pet-clinic-data</module>
        <module>pet-clinic-web</module>
    </modules>
```

__Code from:__ [__pet-clinic-web__](https://github.com/Ivanhola/Spring-Framework-Course-Learning/blob/master/SpringBootPetClinic/pet-clinic-web)
this dependency allows us to access data from the [__pet-clinic-data__](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/SpringBootPetClinic/pet-clinic-data) module, and use it to access everything in the _pet-clinic-data_ module
```xml
       <dependency>
                    <groupId>com.ivanllamas</groupId>
                    <artifactId>pet-clinic-data</artifactId>
                    <version>0.0.1-SNAPSHOT</version>
        </dependency>
```

__Code from:__ [__pet-clinic-data__](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/SpringBootPetClinic/pet-clinic-data): This is an important part of the _pom_ file from our project, this allows us to not create a JAR file when running the application, which allows us to build the project and run the contents from within, allowing the _pet-clinic-data_ maven module to use this projects data, without having to create a __JAR__ file and store everything in it.

```xml

    <properties>
        <spring-boot.repackage.skip>true</spring-boot.repackage.skip>
    </properties>
    
    <build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
                                <executions>
                                    <execution>
                                        <goals>
                                            <goal>repackage</goal>
                                        </goals>
                                        
                                    </execution>
                                </executions>
			</plugin>
                        
		</plugins>
                
	</build>


```
