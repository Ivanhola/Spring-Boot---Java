
package com.ivanllamas.SpringMvcFormTagApp;

import java.util.LinkedHashMap;


/*This student object will store data (firstName string and lastName String)*/
public class Student {
    
    //our student object variables
    private String firstName;
    private String lastName;
    private String Country;
    
    //linked hashMap for our country options <key, value/label>
    private LinkedHashMap <String, String> countryOptions;

    
    
    //our default constructor
    public Student(){
    
        //populate country options: ISO Country Code KEY - VALUE
        
        countryOptions = new LinkedHashMap<>();
        countryOptions.put("BR", "Brazil");
        countryOptions.put("US", "United States");
        countryOptions.put("FR", "France");
        countryOptions.put("DE", "Germany");

    }

    
    
    
    
    /*getters and setters for our form to be able to set and get data.*/

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }
    
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
    
}
