package com.filipe.vaccination_card_api.Infrastructure.Database.DatabaseError;

public class PetMapperError extends RuntimeException{
    public PetMapperError(String message) {
        super(message);
    }
}
