
package com.ivanllamas.services.springdatajpa;

import com.ivanllamas.entity.PetType;
import com.ivanllamas.repository.PetTypeRepository;
import com.ivanllamas.services.PetTypeService;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService{

    private final PetTypeRepository petTypeRepository;

    @Autowired
    public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }
    
    
    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long id) {
        Optional<PetType> petTypeOptional = petTypeRepository.findById(id);
        if(petTypeOptional.isPresent()){
            return petTypeOptional.get();
        }else{
            return null;
        }
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
        
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }

}
