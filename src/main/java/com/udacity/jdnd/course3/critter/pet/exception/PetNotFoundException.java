package com.udacity.jdnd.course3.critter.pet.exception;

public class PetNotFoundException extends RuntimeException {
    public PetNotFoundException() {
        super("Pet not found");
    }

    public PetNotFoundException(String message) {
        super(message);
    }
}
