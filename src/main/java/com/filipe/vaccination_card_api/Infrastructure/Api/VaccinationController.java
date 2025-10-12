package com.filipe.vaccination_card_api.Infrastructure.Api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filipe.vaccination_card_api.Core.Pet.Pet;
import com.filipe.vaccination_card_api.Core.Pet.Services.GetPetService;
import com.filipe.vaccination_card_api.Core.Vaccination.Vaccination;
import com.filipe.vaccination_card_api.Core.Vaccination.DTO.VaccinationRequestDTO;
import com.filipe.vaccination_card_api.Core.Vaccination.DTO.VaccinationResponseDTO;
import com.filipe.vaccination_card_api.Core.Vaccination.Services.ChangeVaccinationDoneService;
import com.filipe.vaccination_card_api.Core.Vaccination.Services.CreateVaccinationService;
import com.filipe.vaccination_card_api.Core.Vaccination.Services.DeleteVaccinationService;
import com.filipe.vaccination_card_api.Core.Vaccination.Services.GetAllDoneVaccinationsService;
import com.filipe.vaccination_card_api.Core.Vaccination.Services.GetAllVaccinationsService;
import com.filipe.vaccination_card_api.Core.Vaccination.Services.GetNextVaccinationsService;
import com.filipe.vaccination_card_api.Core.Vaccination.Services.GetVaccinationService;
import com.filipe.vaccination_card_api.Core.Vaccination.Services.UpdateVaccinationService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/vaccinations")
public class VaccinationController {
    private final CreateVaccinationService createVaccinationService;
    private final GetVaccinationService getVaccinationService;
    private final GetAllVaccinationsService getAllVaccinationsService;
    private final GetNextVaccinationsService getNextVaccinationsService;
    private final GetAllDoneVaccinationsService getAllDoneVaccinationsService;
    private final UpdateVaccinationService updateVaccinationService;
    private final DeleteVaccinationService deleteVaccinationService;
    private final ChangeVaccinationDoneService changeVaccinationDoneService;
    private final GetPetService getPetService;

    public VaccinationController(
        CreateVaccinationService createVaccinationService,
        GetVaccinationService getVaccinationService,
        GetAllVaccinationsService getAllVaccinationsService,
        GetNextVaccinationsService getNextVaccinationsService,
        GetAllDoneVaccinationsService getAllDoneVaccinationsService,
        UpdateVaccinationService updateVaccinationService,
        DeleteVaccinationService deleteVaccinationService,
        ChangeVaccinationDoneService changeVaccinationDoneService,
        GetPetService getPetService
    ){
        this.createVaccinationService = createVaccinationService;
        this.getVaccinationService = getVaccinationService;
        this.getAllVaccinationsService = getAllVaccinationsService;
        this.getNextVaccinationsService = getNextVaccinationsService;
        this.getAllDoneVaccinationsService = getAllDoneVaccinationsService;
        this.updateVaccinationService = updateVaccinationService;
        this.deleteVaccinationService = deleteVaccinationService;
        this.changeVaccinationDoneService = changeVaccinationDoneService;
        this.getPetService = getPetService;
    }

    @PostMapping()
    public ResponseEntity<VaccinationResponseDTO> postMethodName(@RequestBody VaccinationRequestDTO vaccinationRequestDTO) {
        Pet pet = getPetService.execute(vaccinationRequestDTO.petId());
        Vaccination vaccination = new Vaccination(
            vaccinationRequestDTO.date(), 
            vaccinationRequestDTO.nextAdministration(), 
            vaccinationRequestDTO.completed(), 
            vaccinationRequestDTO.vaccineName(), 
            vaccinationRequestDTO.vaccineManufacturer(), 
            vaccinationRequestDTO.vaccineBatchNumber(), 
            vaccinationRequestDTO.veterinarianName(), 
            vaccinationRequestDTO.veterinarianCrmv(), 
            pet);
        vaccination = createVaccinationService.execute(vaccination);
        
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(new VaccinationResponseDTO(
            vaccination.getId(), 
            vaccination.getDate(), 
            vaccination.getNextAdministration(), 
            false, 
            vaccination.getVaccineName(), 
            vaccination.getVaccineManufacturer(), 
            vaccination.getVaccineBatchNumber(), 
            vaccination.getVeterinarianName(), 
            vaccination.getVeterinarianCrmv(), 
            vaccination.getPet().getId()));
    }

    @GetMapping
    public List<VaccinationResponseDTO> getAllVaccinations() {
        List<Vaccination> listOfVaccinations = getAllVaccinationsService.execute();
        List<VaccinationResponseDTO> listOfDtos = 
        listOfVaccinations.stream().map(
            vaccination -> new VaccinationResponseDTO(
                vaccination.getId(), 
                vaccination.getDate(), 
                vaccination.getNextAdministration(), 
                false, 
                vaccination.getVaccineName(), 
                vaccination.getVaccineManufacturer(), 
                vaccination.getVaccineBatchNumber(), 
                vaccination.getVeterinarianName(), 
                vaccination.getVeterinarianCrmv(), 
                vaccination.getPet().getId()
            )
        ).toList();
        
        return listOfDtos;
    }

    @GetMapping("/done/{id}")
    public List<VaccinationResponseDTO> getAllDone(@PathVariable int id) {
        List<Vaccination> listOfVaccinations = getAllDoneVaccinationsService.execute(id);
        List<VaccinationResponseDTO> listOfDtos = 
        listOfVaccinations.stream().map(
            vaccination -> new VaccinationResponseDTO(
                vaccination.getId(), 
                vaccination.getDate(), 
                vaccination.getNextAdministration(), 
                false, 
                vaccination.getVaccineName(), 
                vaccination.getVaccineManufacturer(), 
                vaccination.getVaccineBatchNumber(), 
                vaccination.getVeterinarianName(), 
                vaccination.getVeterinarianCrmv(), 
                vaccination.getPet().getId()
            )
        ).toList();
        return listOfDtos;
    }

    @GetMapping("/nextShot/{id}")
    public List<VaccinationResponseDTO> getNextShots(@PathVariable int id) {
        List<Vaccination> listOfVaccinations = getNextVaccinationsService.execute(id);
        List<VaccinationResponseDTO> listOfDtos = 
        listOfVaccinations.stream().map(
            vaccination -> new VaccinationResponseDTO(
                vaccination.getId(), 
                vaccination.getDate(), 
                vaccination.getNextAdministration(), 
                false, 
                vaccination.getVaccineName(), 
                vaccination.getVaccineManufacturer(), 
                vaccination.getVaccineBatchNumber(), 
                vaccination.getVeterinarianName(), 
                vaccination.getVeterinarianCrmv(), 
                vaccination.getPet().getId()
            )
        ).toList();
        return listOfDtos;
    }
    
    @GetMapping("/{id}")
    public VaccinationResponseDTO getVaccination(@PathVariable int id) {
        Vaccination vaccination = getVaccinationService.execute(id);

        VaccinationResponseDTO vaccinationResponseDTO = new VaccinationResponseDTO(          
            vaccination.getId(), 
            vaccination.getDate(), 
            vaccination.getNextAdministration(), 
            vaccination.getCompleted(), 
            vaccination.getVaccineName(), 
            vaccination.getVaccineManufacturer(), 
            vaccination.getVaccineBatchNumber(), 
            vaccination.getVeterinarianName(), 
            vaccination.getVeterinarianCrmv(), 
            vaccination.getPet().getId()
        );
        return vaccinationResponseDTO;
    }

    @PutMapping("/{id}")
    public VaccinationResponseDTO updateVaccination(@PathVariable int id, @RequestBody VaccinationRequestDTO vaccinationRequestDTO) {
        Pet pet = getPetService.execute(vaccinationRequestDTO.petId());
        Vaccination vaccination = new Vaccination(
            vaccinationRequestDTO.date(), 
            vaccinationRequestDTO.nextAdministration(), 
            vaccinationRequestDTO.completed(), 
            vaccinationRequestDTO.vaccineName(), 
            vaccinationRequestDTO.vaccineManufacturer(), 
            vaccinationRequestDTO.vaccineBatchNumber(), 
            vaccinationRequestDTO.veterinarianName(), 
            vaccinationRequestDTO.veterinarianCrmv(), 
            pet);
        vaccination = updateVaccinationService.execute(vaccination, id);
        
        return new VaccinationResponseDTO(
            vaccination.getId(), 
            vaccination.getDate(), 
            vaccination.getNextAdministration(), 
            false, 
            vaccination.getVaccineName(), 
            vaccination.getVaccineManufacturer(), 
            vaccination.getVaccineBatchNumber(), 
            vaccination.getVeterinarianName(), 
            vaccination.getVeterinarianCrmv(), 
            vaccination.getPet().getId());
    }

    @PatchMapping("/{id}")
    public VaccinationResponseDTO changeDone(@PathVariable int id, @RequestParam boolean done) {
        Vaccination vaccination = getVaccinationService.execute(id);
        vaccination.changeCompleted(done);
        changeVaccinationDoneService.execute(id, done);
        return new VaccinationResponseDTO(
            vaccination.getId(), 
            vaccination.getDate(), 
            vaccination.getNextAdministration(), 
            vaccination.getCompleted(), 
            vaccination.getVaccineName(), 
            vaccination.getVaccineManufacturer(), 
            vaccination.getVaccineBatchNumber(), 
            vaccination.getVeterinarianName(), 
            vaccination.getVeterinarianCrmv(), 
            vaccination.getPet().getId());
    }

    @DeleteMapping("{id}")
    public Boolean deleteVaccination(@PathVariable int id) {
        deleteVaccinationService.execute(id);
        return true;
    }


    

    
    


}

