
package com.ivanllamas.services.springdatajpa;

import com.ivanllamas.entity.Specialty;
import com.ivanllamas.repository.SpecialtyRepository;
import com.ivanllamas.services.SpecialtyService;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialtyService{

    private final SpecialtyRepository specialtyRepository;

    @Autowired
    public SpecialtySDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }
    
    
    
    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long id) {
        Optional<Specialty> specialtyOptional = specialtyRepository.findById(id);
        if(specialtyOptional.isPresent()){
            return specialtyOptional.get();
        }else{
            return null;
        }
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }

    
}
