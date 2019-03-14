
package com.ivanllamas.entity;

import java.util.HashSet;
import java.util.Set;

//pet owner, also inherits from Person
public class Owner extends Person {

    //owner has a set of pets list of pets
    private Set<Pet> pets = new HashSet<>();

    //Add address telephone and other variables
    private String address;
    private String city;
    private String telephone;

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
