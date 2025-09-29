package com.filipe.vaccination_card_api.Core.Vaccination;

import java.time.LocalDate;

import org.springframework.cglib.core.Local;

import com.filipe.vaccination_card_api.Core.Pet.Pet;
import com.filipe.vaccination_card_api.Core.Vaccination.EntityError.VaccinationDateException;
import com.filipe.vaccination_card_api.Core.Vaccination.EntityError.VaccineException;

public class Vaccination {
    private Integer id;
    private LocalDate date;
    private LocalDate nextAdministration;
    private boolean completed;
    private String vaccineName;
    private String vaccineManufacturer;
    private String vaccineBatchNumber;
    private String veterinarianName;
    private String veterinarianCrmv;
    private Pet pet;

    public Vaccination(
        LocalDate date,
        LocalDate nextAdministration,
        boolean completed,
        String vaccineName,
        String vaccineManufacturer,
        String vaccineBatchNumber,
        String veterinarianName,
        String veterinarianCrmv,
        Pet pet
    ) {
        this.validateDate(date, nextAdministration);
        this.validateNextDate(nextAdministration, date);
        this.date = date;
        this.nextAdministration = nextAdministration;
        this.completed = completed;
        this.vaccineName = vaccineName;
        this.vaccineManufacturer = vaccineManufacturer;
        this.vaccineBatchNumber = vaccineBatchNumber;
        this.veterinarianName = veterinarianName;
        this.veterinarianCrmv = veterinarianCrmv;
        this.pet = pet;

    }

    public Integer getId() {
        return this.id;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public LocalDate getNextAdministration() {
        return this.nextAdministration;
    }

    public boolean getCompleted() {
        return this.completed;
    }

    public String getVaccineName() {
        return this.vaccineName;
    }

    public String getVaccineManufacturer() {
        return this.vaccineManufacturer;
    }

    public String getVaccineBatchNumber() {
        return this.vaccineBatchNumber;
    }

    public String getVeterinarianName() {
        return this.veterinarianName;
    }

    public String getVeterinarianCrmv() {
        return this.veterinarianCrmv;
    }

    public Pet getPet() {
        return this.pet;
    }

    public void changeDate(LocalDate newDate) {
        validateDate(newDate, this.getNextAdministration());
        this.date = newDate;
    }

    public void changeNextDate(LocalDate newDate) {
        validateNextDate(newDate, this.getDate());
        this.nextAdministration = newDate;
    }

    private void validateDate(LocalDate date, LocalDate nextDate) {
        if (date.isAfter(nextDate)) {
            throw new VaccinationDateException("First shot date cant be after than next administration date.");
        }
    }

    private void validateNextDate(LocalDate date, LocalDate nextDate) {
        if (nextDate.isAfter(date)) {
            throw new VaccinationDateException("First shot date cant be after the next administration date");
        }
    }

    public void changeCompleted() {
        this.completed = !this.getCompleted();
    }

    private void validateString(String text) {
        if (text.isBlank()) {
            throw new VaccineException("Name field cant be empty");
        }
    }

    public void changeVaccineName(String newName) {
        validateString(newName);
        this.vaccineName = newName;
    }

    public void changeVaccineManufacturer(String newName) {
        validateString(newName);
        this.vaccineManufacturer = newName;
    }

    public void changeBatchNumber(String newBatchNumber) {
        validateString(newBatchNumber);
        this.vaccineBatchNumber = newBatchNumber;
    }

    public void changeVeterinarianName(String newName) {
        validateString(newName);
        this.veterinarianName = newName;
    }

    public void changeVeterinarianCrmv(String newCrmv) {
        validateString(newCrmv);
        this.veterinarianCrmv = newCrmv;
    }

}
