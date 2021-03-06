
package com.ivanllamas.entity;



import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


/*
*this will be the 'base' entity that houses an ID value that our entities will implement.
*/

//MappedSuperclass tells spring data that other objects will derive from this entity (other classes extend this)
// and will NOT be created in the datbase

@MappedSuperclass
public class BaseEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*Constructors*/
    public BaseEntity(){
        
    }
    
    public BaseEntity(Long id) {
        this.id = id;
    }

    
    //method used to check if the OWner/person/entity is new
    
    public boolean isNew(){
        //if id is null return false as in not new
        return this.id == null;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
