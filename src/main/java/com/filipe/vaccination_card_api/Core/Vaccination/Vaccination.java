package com.filipe.vaccination_card_api.Core.Vaccination;

import java.time.LocalDate;

import com.filipe.vaccination_card_api.Core.Pet.Pet;

public class Vaccination {

    private LocalDate date;
    private LocalDate nextAdministration;
    private boolean completed;
    private String vaccineName;
    private String vaccineManufacturer;
    private String vaccineBatchNumber;
    private String veterinarianName;
    private String veterinarianCrmv;
    private Pet pet;

}
