
package com.ivanllamas.entity;

import java.util.Set;

//pet owner, also inherits from Person
public class Owner extends Person {

    //owner has a set of pets list of pets
    private Set<Pet> pets;


    public Set<Pet> getPets() {
        return this.pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

}
