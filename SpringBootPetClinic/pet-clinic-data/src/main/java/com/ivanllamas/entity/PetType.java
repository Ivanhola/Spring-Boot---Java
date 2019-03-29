
package com.ivanllamas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "types")
public class PetType extends BaseEntity{
    
    
    
    @Column(name = "name")
    private String name;

    
    //constructors
    
    
    public PetType() {
    }

    public PetType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
