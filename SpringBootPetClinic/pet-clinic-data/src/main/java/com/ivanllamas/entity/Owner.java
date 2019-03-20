
package com.ivanllamas.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//pet owner, also inherits from Person
@Entity
@Table(name = "owners")
public class Owner extends Person {

    //owner has a set of pets list of pets, cascade means if you delete an owner, it will delete 'down' the list
    //if you create a pet and assign it, it will cascade down to the pet entity and create the pet
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    @Column(name = "address")
    private String address;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "telephone")
    private String telephone;

    
    //constructors
    
    public Owner() {
    }

    public Owner(String address, String city, String telephone) {
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }
    
    

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<Pet> getPets() {
        return this.pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

}
