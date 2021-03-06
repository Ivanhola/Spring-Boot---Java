
package com.ivanllamas.RecipeProject.Converters;

import com.ivanllamas.RecipeProject.CommandObjects.NotesCommand;
import com.ivanllamas.RecipeProject.model.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes>{

    @Nullable
    @Override
    public Notes convert(NotesCommand source) {
    if(source == null){
        return null;
    }    
    
    final Notes notes = new Notes();
    notes.setId(source.getId());
    notes.setRecipeNotes(source.getRecipeNotes());
    return notes;
    }
}
