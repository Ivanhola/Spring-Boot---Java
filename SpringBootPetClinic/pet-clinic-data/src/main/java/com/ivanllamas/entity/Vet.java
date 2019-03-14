
package com.ivanllamas.entity;

import java.util.HashSet;
import java.util.Set;

//inheritence, Vet is a Person
public class Vet extends Person{

    //ADDED SET OF SPECIALTY
    private Set<Specialty> specialties = new HashSet<>();

    public Set<Specialty> getSpecialties() {
        return this.specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }


    

}
