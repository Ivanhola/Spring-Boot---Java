
package com.ivanllamas.RecipeProject.Converters;

import com.ivanllamas.RecipeProject.CommandObjects.UnitOfMeasureCommand;
import com.ivanllamas.RecipeProject.model.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand>{

    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure source) {
        if(source == null){
            return null;
        }
        
        final UnitOfMeasureCommand uomc = new UnitOfMeasureCommand();
        uomc.setId(source.getId());
        uomc.setDescription(source.getDescription());
        return uomc;
    }

}
