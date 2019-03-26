
package com.ivanllamas.RecipeProject.service;

import com.ivanllamas.RecipeProject.CommandObjects.UnitOfMeasureCommand;
import com.ivanllamas.RecipeProject.Converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.ivanllamas.RecipeProject.repository.UnitOfMeasureRepository;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService{

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    //we will need to return a unit of measure command
    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    @Autowired       
    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository, UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureCommand) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureCommand;
    }
            
            
    @Override
    public Set<UnitOfMeasureCommand> listAllUoms() {
        
        return StreamSupport.stream(unitOfMeasureRepository.findAll().spliterator(), false)
                .map(unitOfMeasureToUnitOfMeasureCommand::convert).collect(Collectors.toSet());
         }

}
