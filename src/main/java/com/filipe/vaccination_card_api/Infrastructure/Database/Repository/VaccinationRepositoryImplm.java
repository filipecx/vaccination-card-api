package com.filipe.vaccination_card_api.Infrastructure.Database.Repository;

import java.util.List;

import com.filipe.vaccination_card_api.Core.Vaccination.IvaccinationRepository;
import com.filipe.vaccination_card_api.Core.Vaccination.Vaccination;
import com.filipe.vaccination_card_api.Infrastructure.Database.DatabaseError.VaccinationEntityException;
import com.filipe.vaccination_card_api.Infrastructure.Database.Entity.VaccinationEntity;
import com.filipe.vaccination_card_api.Infrastructure.Database.Mapper.VaccinationMapper;

public class VaccinationRepositoryImplm implements IvaccinationRepository{
    private final VaccinationEntityRepository vaccinationEntityRepository;
    private final VaccinationMapper mapper;

    public VaccinationRepositoryImplm(VaccinationEntityRepository vaccinationEntityRepository, VaccinationMapper mapper) {
        this.mapper = mapper;
        this.vaccinationEntityRepository = vaccinationEntityRepository;
    }

    @Override
    public Vaccination createVaccination(Vaccination vaccination) {
        VaccinationEntity vaccinationEntity = mapper.toEntity(vaccination);
        VaccinationEntity savedVaccination = vaccinationEntityRepository.save(vaccinationEntity);

        return mapper.toDomain(savedVaccination);
    }

    @Override
    public Vaccination updateVaccination(Vaccination vaccination, int id) {
        VaccinationEntity vaccinationEntity = vaccinationEntityRepository.findById(id)
        .orElseThrow(() -> new VaccinationEntityException("No vaccination found"));

        VaccinationEntity updatedVaccination = vaccinationEntityRepository.save(vaccinationEntity);

        return mapper.toDomain(updatedVaccination);
    }

    @Override
    public Vaccination getVaccination(int id) {
        VaccinationEntity vaccinationEntity = vaccinationEntityRepository.findById(id)
        .orElseThrow(() -> new VaccinationEntityException("No vaccination found by this id"));

        Vaccination vaccination = mapper.toDomain(vaccinationEntity);
        return vaccination;
    }

    @Override
    public List<Vaccination> getAllVaccinations() {
        List<VaccinationEntity> listOfEntities = vaccinationEntityRepository.findAll();

        List<Vaccination> listOfVaccinations = mapper.toDomainList(listOfEntities);

        return listOfVaccinations;
    }

    @Override
    public List<Vaccination> getAllDoneVaccinationsByPetId(int id) {
        List<VaccinationEntity> listOEntities = vaccinationEntityRepository.findAllByIdDoneFalse(id);
        List<Vaccination> listOfVaccinations = mapper.toDomainList(listOEntities);

        return listOfVaccinations;
    }

    @Override
    public List<Vaccination> getNextVacinationsByPetId(int id) {
        List<VaccinationEntity> listOfEntities = vaccinationEntityRepository.findAllByIdDoneFalseOrderByDateDesc(id);
        List<Vaccination> listOfVaccinations = mapper.toDomainList(listOfEntities);

        return listOfVaccinations;

    }

    @Override
    public Boolean changeVaccinationDone(int id, boolean active) {
        VaccinationEntity entity = vaccinationEntityRepository.findById(id)
        .orElseThrow(() -> new VaccinationEntityException("No vaccination found by this id"));

        entity.setCompleted(active);
        vaccinationEntityRepository.save(entity);

        return true;
    }

    @Override
    public Boolean deleteVaccination(int id) {
        vaccinationEntityRepository.findById(id)
        .orElseThrow(() -> new VaccinationEntityException("No vaccination found by this id"));

        vaccinationEntityRepository.deleteById(id);
        return true;

    }

}
