package com.filipe.vaccination_card_api.Infrastructure.Database.DatabaseError;

public class PetEntityException extends RuntimeException{
    public PetEntityException(String message) {
        super(message);
    }
}
