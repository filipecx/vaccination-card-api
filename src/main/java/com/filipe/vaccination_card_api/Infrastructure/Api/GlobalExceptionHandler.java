package com.filipe.vaccination_card_api.Infrastructure.Api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.filipe.vaccination_card_api.Core.Pet.EntityError.PetError;
import com.filipe.vaccination_card_api.Core.Vaccination.EntityError.VaccinationDateException;
import com.filipe.vaccination_card_api.Core.Vaccination.EntityError.VaccineException;
import com.filipe.vaccination_card_api.Infrastructure.Database.DatabaseError.PetEntityException;
import com.filipe.vaccination_card_api.Infrastructure.Database.DatabaseError.VaccinationEntityException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(PetError.class)
    public ResponseEntity<String> handlePetNotFound(PetError ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body(ex.getMessage());
    }

    @ExceptionHandler(PetEntityException.class)
    public ResponseEntity<String> handEntityNotFound(PetEntityException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(VaccinationDateException.class)
    public ResponseEntity<String> handleVaccinationDateExecpetion(VaccinationDateException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(VaccineException.class)
    public ResponseEntity<String> handleVaccinationDateExecpetion(VaccineException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(VaccinationEntityException.class)
    public ResponseEntity<String> handleVaccinationEntityEx(VaccinationEntityException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
