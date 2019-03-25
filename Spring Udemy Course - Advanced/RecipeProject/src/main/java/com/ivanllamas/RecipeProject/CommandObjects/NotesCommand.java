
package com.ivanllamas.RecipeProject.CommandObjects;


public class NotesCommand {

    private Long id;
    private RecipeCommand recipeCommand;
    private String recipeNotes;

    
    /*No-Arg Constructor*/
    public NotesCommand() {
    }
    
    /*Getters and Setter*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RecipeCommand getRecipeCommand() {
        return recipeCommand;
    }

    public void setRecipeCommand(RecipeCommand recipeCommand) {
        this.recipeCommand = recipeCommand;
    }

    public String getRecipeNotes() {
        return recipeNotes;
    }

    public void setRecipeNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }
    
    
}
