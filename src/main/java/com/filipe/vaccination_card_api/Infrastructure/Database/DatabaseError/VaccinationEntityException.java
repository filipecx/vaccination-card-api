package com.filipe.vaccination_card_api.Infrastructure.Database.DatabaseError;

public class VaccinationEntityException extends RuntimeException{
    public VaccinationEntityException(String message) {
        super(message);
    }
}
