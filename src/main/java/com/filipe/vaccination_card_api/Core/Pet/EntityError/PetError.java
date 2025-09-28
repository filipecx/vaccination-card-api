package com.filipe.vaccination_card_api.Core.Pet.EntityError;

public class PetError extends RuntimeException{
    public PetError(String message) {
        super(message);
    }

}
