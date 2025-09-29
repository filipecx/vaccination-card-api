package com.filipe.vaccination_card_api.Core.Vaccination;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.filipe.vaccination_card_api.Core.Pet.Pet;
import com.filipe.vaccination_card_api.Core.Vaccination.EntityError.VaccinationDateException;
import com.filipe.vaccination_card_api.Core.Vaccination.EntityError.VaccineException;

public class VaccinationTest {

    @Test
    @DisplayName("It should be able to create a new vaccination. ")
    void testCreateVaccinationSuccess() {
        Pet pet = new Pet("Maya", "imageurl");
        Vaccination vaccination = new Vaccination(LocalDate.parse("2025-09-29"), 
        LocalDate.parse("2025-10-29"), 
        false, 
        "Polivalente", "Virbac", "L12345A",
         "Hugo Leon", 
         "BB309",
          pet);

        assertNotNull(vaccination);
        assertEquals(vaccination.getNextAdministration(), LocalDate.parse("2025-10-29"));
    }

    @Test
    @DisplayName("It should not be able to change nextDate to an earlier date than the first shot date.")
    void changeNextDateFail() {
        Pet pet = new Pet("Maya", "imageurl");
        Vaccination vaccination = new Vaccination(LocalDate.parse("2025-09-29"), 
        LocalDate.parse("2025-10-29"), 
        false, 
        "Polivalente", "Virbac", "L12345A",
         "Hugo Leon", 
         "BB309",
          pet);
        assertThrows(VaccinationDateException.class, () -> {
            vaccination.changeNextDate(LocalDate.parse("2025-08-29"));
        });      
    }

    @Test
    @DisplayName("It should not be able to change first first shot date to later than the next shot date.")
    void changeDateFail() {
        Pet pet = new Pet("Maya", "imageurl");
        Vaccination vaccination = new Vaccination(LocalDate.parse("2025-09-29"), 
        LocalDate.parse("2025-10-29"), 
        false, 
        "Polivalente", "Virbac", "L12345A",
         "Hugo Leon", 
         "BB309",
          pet);
        assertThrows(VaccinationDateException.class, () -> {
            vaccination.changeDate(LocalDate.parse("2025-11-29"));
        });      
    }

    @Test
    @DisplayName("It should not be able to change vaccine name to an empty string. ")
    void changeVaccineNameFail() {
        Pet pet = new Pet("Maya", "imageurl");
        Vaccination vaccination = new Vaccination(LocalDate.parse("2025-09-29"), 
        LocalDate.parse("2025-10-29"), 
        false, 
        "Polivalente", "Virbac", "L12345A",
         "Hugo Leon", 
         "BB309",
          pet);
        assertThrows(VaccineException.class, () -> {
            vaccination.changeVaccineName("");
        });  
    }

}
