
package com.ivanllamas.RecipeProject.CommandObjects;
/*

It is good practice not to expose our main entity objects into the Web View,
so we must create Command objects, which will mimic the properties of our Entities, and we can then convert
the values from this object to the ones in our entity.

*/
//Command objects mimic properties of our entities,
public class CategoryCommand {

    public Long id;
    public String description;
    
    
    /*No Arg Constructor*/
    public CategoryCommand() {
    }


    
    /*Getters and Setters*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
}
