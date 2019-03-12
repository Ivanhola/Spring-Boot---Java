# Documentation for pet-clinic-data

Since our project is broken up into 2 modules, this will be the documentation for the __pet-clinic-data__ module, this module takes care of the 
'data-layer' backend of things, Working with _Entities, Repository, Services, Maps_ to iteract with our database and the objects it will store.

## Packages

- [Services](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/SpringBootPetClinic/pet-clinic-data/src/main/java/com/ivanllamas/services)
- [Entity](https://github.com/Ivanhola/Spring-Framework-Course-Learning/tree/master/SpringBootPetClinic/pet-clinic-data/src/main/java/com/ivanllamas/entity)


## Entity Package

Our 3 __Main__ entities are 
- [__Person__](https://github.com/Ivanhola/Spring-Framework-Course-Learning/blob/master/SpringBootPetClinic/pet-clinic-data/src/main/java/com/ivanllamas/entity/Person.java)
- [__Pet__](https://github.com/Ivanhola/Spring-Framework-Course-Learning/blob/master/SpringBootPetClinic/pet-clinic-data/src/main/java/com/ivanllamas/entity/Pet.java)
- [__BaseEntity__](https://github.com/Ivanhola/Spring-Framework-Course-Learning/blob/master/SpringBootPetClinic/pet-clinic-data/src/main/java/com/ivanllamas/entity/BaseEntity.java)

We call them __Main__ entities, because other entities like [Owner](https://github.com/Ivanhola/Spring-Framework-Course-Learning/blob/master/SpringBootPetClinic/pet-clinic-data/src/main/java/com/ivanllamas/entity/Owner.java) and [Vet](https://github.com/Ivanhola/Spring-Framework-Course-Learning/blob/master/SpringBootPetClinic/pet-clinic-data/src/main/java/com/ivanllamas/entity/Vet.java) _inherit_ from our Person entity, it is also important to note that all entities
_inherit_ from __BaseEntity__, which is an entity that simply provides an __ID__ value for our entities.

Lets take a look at our __PetType__ entity which is composed of `Getters and Setters` for our variables below.
```Java
public class Pet extends BaseEntity{


    private PetType petType;
    private Owner owner;
    private LocalDate birthDate;

```
It takes a __PetType__ object and an __Owner__ object

A more general entity would be our __Person__ object, which takes in a first name and last name, with its getters and setters (No constructor)
```Java
public class Person extends BaseEntity{

    private String firstName;
    private String lastName;
```
