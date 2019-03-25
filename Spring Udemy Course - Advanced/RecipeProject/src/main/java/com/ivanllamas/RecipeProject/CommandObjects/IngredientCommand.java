
package com.ivanllamas.RecipeProject.CommandObjects;

import java.math.BigDecimal;


public class IngredientCommand {

    private Long id;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasureCommand unitOfMeasureCommand;

    /*no-arg constructor*/
    public IngredientCommand() {
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public UnitOfMeasureCommand getUnitOfMeasureCommand() {
        return unitOfMeasureCommand;
    }

    public void setUnitOfMeasureCommand(UnitOfMeasureCommand unitOfMeasureCommand) {
        this.unitOfMeasureCommand = unitOfMeasureCommand;
    }
    
    
}
