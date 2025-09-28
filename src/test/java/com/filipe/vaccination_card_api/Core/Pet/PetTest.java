package com.filipe.vaccination_card_api.Core.Pet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.filipe.vaccination_card_api.Core.Pet.EntityError.PetError;

public class PetTest {

    @Test
    @DisplayName("It should be able to create a new pet. ") 
    void testCreatePetSuccess() {
        Pet pet = new Pet("Maya", "urlmtoloka");

        assertNotNull(pet);
        assertEquals("Maya", pet.getName());
    }

    @Test
    @DisplayName("It should NOT be able to create a new pet. ") 
    void testCreatePetFail() {

        assertThrows(PetError.class, () -> {
            new Pet("M", "urlmtoloka");
        });
    }

    @Test
    @DisplayName("It should be able to change the pet's name. ")
    void testChangePetNameSuccess() {
        Pet pet = new Pet("Maya", "urlmtoloka");
        pet.changePetName("Magda");

        assertEquals("Magda", pet.getName());
    }

    @Test
    @DisplayName("It should NOT be able to change the pet's name. ")
    void testChangePetNameFail() {
        Pet pet = new Pet("Maya", "urlmtoloka");
        
        assertThrows(PetError.class, () -> {
            pet.changePetName("M");
        });
        
    }

    @Test
    @DisplayName("It should be able to change if pet is active. ")
    void testChangeActiveSuccess() {
        Pet pet = new Pet("Maya", "urlmtoloka");
        pet.changeActive(false);

        assertEquals(false, pet.getActive());
    }
}
