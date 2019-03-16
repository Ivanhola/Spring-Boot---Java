# Documentation for Recipe project

## Technologies

- Entities
- Spring Data JPA + Repositories
- H2 Database
- JPA Database Mappings

## Packages

- [__Controller__](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course%20-%20Advanced/RecipeProject/src/main/java/com/ivanllamas/RecipeProject/controller)
- [__Entity__](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course%20-%20Advanced/RecipeProject/src/main/java/com/ivanllamas/RecipeProject/model)
- [__Repository__](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/Spring%20Udemy%20Course%20-%20Advanced/RecipeProject/src/main/java/com/ivanllamas/RecipeProject/repository)

## Controller 
As We've covered in other examples, the Controller takes care of the GET requests and HTTP protocols depending on URL.

## Entity
This project makes heavy emphasis on spring data JPA Entities and annotations associated with it like __@OneToOne, @OneToMany, @ManyToOne, @ManyToMany__ and others. We will break down the use of each annotation in the following code snippets from our entity classes and the Structure of the database.

Our _'main'_ Table in our database is __Recipe__
