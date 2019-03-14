
package com.ivanllamas.entity;

import java.util.Set;

//pet owner, also inherits from Person
public class Owner extends Person {

    private Set<Pet> pets;


    public Set<Pet> getPets() {
        return this.pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

}
