package com.ivanllamas.RecipeProject.service;

import com.ivanllamas.RecipeProject.CommandObjects.UnitOfMeasureCommand;
import java.util.Set;

/**
 *
 * @author beandog
 */
public interface UnitOfMeasureService {
 
    Set<UnitOfMeasureCommand> listAllUoms();
}
