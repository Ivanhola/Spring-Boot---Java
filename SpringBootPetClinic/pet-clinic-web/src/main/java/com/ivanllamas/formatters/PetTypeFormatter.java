
package com.ivanllamas.formatters;

import com.ivanllamas.entity.PetType;
import com.ivanllamas.services.PetTypeService;
import java.text.ParseException;
import java.util.Collection;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class PetTypeFormatter implements Formatter<PetType>{
    private final PetTypeService petTypeService;

    @Autowired
    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }
    
    

    @Override
    public String print(PetType petType, Locale locale){
        return petType.getName();
    }
    
    //when it goes to parse a pettype it takes in a string of a pettype and iterate through a list of all pettypes
    //get the name, and return that.
    @Override
    public PetType parse(String text, Locale locale) throws ParseException{
        Collection<PetType> findPetTypes = petTypeService.findAll();
        
        for(PetType type : findPetTypes){
            if(type.getName().equals(text)){
                return type;
            }
        }
        throw new ParseException(("Type not found") + text, 0);
    }
}
