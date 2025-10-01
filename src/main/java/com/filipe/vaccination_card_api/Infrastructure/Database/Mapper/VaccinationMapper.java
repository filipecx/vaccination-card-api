package com.filipe.vaccination_card_api.Infrastructure.Database.Mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.filipe.vaccination_card_api.Core.Pet.Pet;
import com.filipe.vaccination_card_api.Core.Pet.Services.GetPetService;
import com.filipe.vaccination_card_api.Core.Vaccination.Vaccination;
import com.filipe.vaccination_card_api.Infrastructure.Database.DatabaseError.VaccinationEntityException;
import com.filipe.vaccination_card_api.Infrastructure.Database.Entity.PetEntity;
import com.filipe.vaccination_card_api.Infrastructure.Database.Entity.VaccinationEntity;

@Component
public class VaccinationMapper {
    public Vaccination toDomain(VaccinationEntity vaccinationEntity) {
        if ( vaccinationEntity == null) {
            throw new VaccinationEntityException(("No vaccination entity received. "));
        }
        Pet pet = new Pet(vaccinationEntity.getPet().getId(), vaccinationEntity.getPet().getName(), vaccinationEntity.getPet().getImageUrl(), vaccinationEntity.getPet().isActive());
        return new Vaccination(
            vaccinationEntity.getId(),
            vaccinationEntity.getDate(), 
            vaccinationEntity.getNextAdministration(),
            vaccinationEntity.isCompleted(), 
            vaccinationEntity.getVaccineName(), 
            vaccinationEntity.getVaccineManufacturer(), 
            vaccinationEntity.getVaccineBatchNumber(), 
            vaccinationEntity.getVeterinarianName(), 
            vaccinationEntity.getVeterinarianCrmv(),
            pet);
    }

    public VaccinationEntity toEntity(Vaccination vaccinationDomain, PetEntity petEntity) {
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
        vaccinationEntity.setPet(petEntity);
        return vaccinationEntity;
    }

    public List<Vaccination> toDomainList(List<VaccinationEntity> vaccinationEntities) {
        if (vaccinationEntities == null) {
            throw new VaccinationEntityException("No list of vaccinations found");
        }

        return vaccinationEntities.stream().map(vaccination -> this.toDomain(vaccination)).toList();
    }
}
