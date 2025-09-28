package com.filipe.vaccination_card_api.Core.Vaccination.EntityError;

public class VaccineException extends RuntimeException{
    public VaccineException(String message) {
        super(message);
    }
}
