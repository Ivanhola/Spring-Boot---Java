
package com.ivanllamas.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//inheritence, Vet is a Person
@Entity
@Table(name = "vets")
public class Vet extends Person{

    //ADDED SET OF SPECIALTY, loads everything at once with EAGER
    //This creates a new table in the database, and sets up 2 join Columns where vet knows about secialty
    //and specialty knows about the vet objects
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id"), 
            inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Specialty> specialties = new HashSet<>();

    public Set<Specialty> getSpecialties() {
        return this.specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }


    

}
