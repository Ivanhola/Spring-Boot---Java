
package com.ivanllamas.RecipeProject.CommandObjects;


public class UnitOfMeasureCommand {

    private Long id;
    private String description;

    /*No-Arg Constructor*/
    public UnitOfMeasureCommand() {
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
