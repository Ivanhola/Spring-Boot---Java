
package com.ivanllamas.RecipeProject.Converters;

import com.ivanllamas.RecipeProject.CommandObjects.UnitOfMeasureCommand;
import com.ivanllamas.RecipeProject.model.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/*This Converts a UnitOfMeasureCommand object to a UnitOfMeasure Entity*/
@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure>{

    
    //pretty simple method, takes in a UoMCommand and gets the variable data and adds to a UoM Object
    //@Nullable because the object can be null according to the database
    
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand source) {
        if(source == null){
            return null;
         }
        
        final UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(source.getId());
        uom.setDescription(source.getDescription());
        return uom;
    }

}
