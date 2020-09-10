package com.udacity.jdnd.course3.critter.pet.service;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.pet.exception.PetNotFoundException;
import com.udacity.jdnd.course3.critter.pet.repository.PetRepository;
import com.udacity.jdnd.course3.critter.user.entity.Customer;
import com.udacity.jdnd.course3.critter.user.exception.CustomerNotFoundException;
import com.udacity.jdnd.course3.critter.user.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private CustomerService customerService;

    public List<Pet> list() {
        return petRepository.findAll();
    }

    public Pet findById(Long id) {
        return petRepository.findById(id).orElseThrow(PetNotFoundException::new);
    }

    public Pet save(Pet pet) {
        Pet savedPet = petRepository.save(pet);

        Customer owner = customerService.findById(savedPet.getOwner().getId());
        owner.getPets().add(savedPet);
        customerService.save(owner);

        return savedPet;
    }

    public List<Pet> listAllWithOwner(Long ownerId) {
        return petRepository.findAllByOwnerId(ownerId);
    }
}
