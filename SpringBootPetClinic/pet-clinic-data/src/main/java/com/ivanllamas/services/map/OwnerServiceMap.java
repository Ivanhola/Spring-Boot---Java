
package com.ivanllamas.services.map;

import com.ivanllamas.entity.Owner;
import com.ivanllamas.entity.Pet;
import com.ivanllamas.services.CrudService;
import com.ivanllamas.services.OwnerService;
import com.ivanllamas.services.PetService;
import com.ivanllamas.services.PetTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import org.springframework.context.annotation.Profile;

@Service
@Profile({"default","map"})
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {

    //used to check 
    private final PetTypeService petTypeService;
    private final PetService petService;

    @Autowired
    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }



    

    @Override
    public Set<Owner> findAll() {
        //this calls the abstract map service class method
    return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
    return super.findById(id);
    }

/*Lets break down whats going on in this method
We check to see if the object is null, if it is not null, we check to see if the Owner has a pet. If the owner
has a pet we run a method to iterate through the pets, which then checks if the pettype is set.

 */
    @Override
    public Owner save(Owner object) {

        if(object != null){
            if(object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else{
                        throw new RuntimeException("pet type is required");
                    }
                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());                       
                    }
                });
            }
             return super.save(object);
             
        }else{
            return null;
        }

    }

    @Override
    public void delete(Owner object) {
     super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll().stream().filter(owner -> owner.getLastName()
                .equalsIgnoreCase(lastName)).findFirst().orElse(null);
    }




}
