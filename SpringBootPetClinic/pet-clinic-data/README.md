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
- [__Visit__](https://github.com/Ivanhola/Spring-Framework-Course-Learning/blob/master/SpringBootPetClinic/pet-clinic-data/src/main/java/com/ivanllamas/entity/Visit.java)

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

## Service Package
This package is used to mimic what goes on in the behind the scenes while using Spring Data JPA - Hibernate.
We have our interfaces for our entities that extend a __CrudService__ that has CRUD methods. And we then use __MapServices__ to interact with the CRUD interfaces.

Our __Main__ MapService is [__AbstractMapService__](https://github.com/Ivanhola/Spring-Framework-Course-Learning/blob/master/SpringBootPetClinic/pet-clinic-data/src/main/java/com/ivanllamas/services/map/AbstractMapService.java) which is our main map used to save objects update or delete them.
```Java
 Set<T> findAll(){
    return new HashSet<>(map.values());
    }
    
    T findById(ID id){
        return map.get(id);
                
    }
    
    T save(T object){
        //if the object is not null
        if (object != null) {

            //we are going to get the current id
            if (object.getId() == null) {
                //and set the ID equal to the next ID for example; 3 -> 4
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        } else{
            throw new RuntimeException("Object cannot be null");
        }

        
        return object;
    }
    
    void deleteById(ID id){
        map.remove(id);
    }
    
    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    //manage our LONG ID values
    private Long getNextId(){
        Long nextId = null;

        //if our Id is 0 it will throw NoSuchElementException which will make the ID == 1L, and the next
        //this program is run, it will go from 1L and increment
        try{
             nextId = Collections.max(map.keySet()) +  1;
        }catch(NoSuchElementException e){
            nextId = 1L;

        }
       

        return nextId;
        
    }
    
    
```


Our Other map services simply extend this class, and make use of its methods while implementing the ServiceInterfaces heres an example of other map services that use the __AbstractMapService__ to save objects

```Java
@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    
}
```
