package com.filipe.vaccination_card_api.Infrastructure.Database.Mapper;

import java.util.List;

import com.filipe.vaccination_card_api.Core.Vaccination.Vaccination;
import com.filipe.vaccination_card_api.Infrastructure.Database.DatabaseError.VaccinationEntityException;
import com.filipe.vaccination_card_api.Infrastructure.Database.Entity.VaccinationEntity;

public class VaccinationMapper {
    public Vaccination toDomain(VaccinationEntity vaccinationEntity) {
        if ( vaccinationEntity == null) {
            throw new VaccinationEntityException(("No vaccination entity received. "));
        }

        return new Vaccination(
            vaccinationEntity.getDate(), 
            vaccinationEntity.getNextAdministration(),
            vaccinationEntity.isCompleted(), 
            vaccinationEntity.getVaccineName(), 
            vaccinationEntity.getVaccineManufacturer(), 
            vaccinationEntity.getVaccineBatchNumber(), 
            vaccinationEntity.getVeterinarianName(), 
            vaccinationEntity.getVeterinarianCrmv(),
            vaccinationEntity.getPet());
    }

    public VaccinationEntity toEntity(Vaccination vaccinationDomain) {
        if (vaccinationDomain == null) {
            throw new VaccinationEntityException("No vaccination domain received. ");
        }
        VaccinationEntity vaccinationEntity = new VaccinationEntity();
        vaccinationEntity.setDate(vaccinationDomain.getDate());
        vaccinationEntity.setNextAdministration(vaccinationDomain.getNextAdministration());
        vaccinationEntity.setCompleted(vaccinationDomain.getCompleted());
        vaccinationEntity.setVaccineName(vaccinationDomain.getVaccineName());
        vaccinationEntity.setVaccineManufacturer(vaccinationDomain.getVaccineManufacturer());
        vaccinationEntity.setVaccineBatchNumber(vaccinationDomain.getVaccineBatchNumber());
        vaccinationEntity.setVeterinarianName(vaccinationDomain.getVeterinarianName());
        vaccinationEntity.setVeterinarianCrmv(vaccinationDomain.getVeterinarianCrmv());
        vaccinationEntity.setPet(vaccinationDomain.getPet());
        return vaccinationEntity;
    }

    public List<Vaccination> toDomainList(List<VaccinationEntity> vaccinationEntities) {
        if (vaccinationEntities == null) {
            throw new VaccinationEntityException("No list of vaccinations found");
        }

        return vaccinationEntities.stream().map(vaccination -> this.toDomain(vaccination)).toList();
    }
}
