package com.filipe.vaccination_card_api.Core.Vaccination.EntityError;

public class VaccinationDateException extends RuntimeException{
    public VaccinationDateException(String message) {
        super(message);
    }
}
