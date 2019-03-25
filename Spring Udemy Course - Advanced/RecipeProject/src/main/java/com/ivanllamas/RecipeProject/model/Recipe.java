package com.ivanllamas.RecipeProject.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/** RECIPE ENTITY
 * Recipe class has a relationship with Notes class
 */
@Entity
public class Recipe {

    //PRIMARY KEY
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    
    @Lob
    private String directions;
    
    //this defines the relationship from recipe class, 
    //the Set of Ingredient objects is going to be in a property called recipe
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();
    
    @Lob
    private Byte[] image;
    
    
    //annotation to mark our enum in our database
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty; 

    //relationship to Note object
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;
    
    
    //joining tables for our recipe -> category, and the columns will be from recipe to category as 'recipe_id'
    //and from category to recipe as 'category_id'
    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"), 
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    //getters and setters

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrepTime() {
        return this.prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return this.cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServings() {
        return this.servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDirections() {
        return this.directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Byte[] getImage() {
        return this.image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Notes getNotes() {
        return this.notes;
    }

    public void setNotes(Notes notes) {
        if(notes != null){
        this.notes = notes;
        //convenience to set Recipe
        notes.setRecipe(this);
        }
    }
    
    //method for adding ingredient to our recipe
    public Recipe addIngredient(Ingredient ingredient){
        //sets the recipe to the 'Recipe' object for example guacRecipe.addIngredient(...) sets recipe for guacRecipe(this)
       ingredient.setRecipe(this);
       this.ingredients.add(ingredient);
       return this;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Recipe other = (Recipe) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    

}