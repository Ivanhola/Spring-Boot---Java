
package com.ivanllamas.entity;



import java.io.Serializable;


//this will be the 'base' entity that houses an ID value that our entities will implement.
public class BaseEntity implements Serializable{

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
