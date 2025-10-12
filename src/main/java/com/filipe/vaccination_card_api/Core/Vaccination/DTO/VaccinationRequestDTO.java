package com.filipe.vaccination_card_api.Core.Vaccination.DTO;

import java.time.LocalDate;

public record VaccinationRequestDTO(
    LocalDate date,
    LocalDate nextAdministration,
    boolean completed,
    String vaccineName,
    String vaccineManufacturer,
    String vaccineBatchNumber,
    String veterinarianName,
    String veterinarianCrmv,
    Integer petId

) {

    
}
