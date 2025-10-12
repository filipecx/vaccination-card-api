package com.filipe.vaccination_card_api.Infrastructure.Api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filipe.vaccination_card_api.Core.Pet.Pet;
import com.filipe.vaccination_card_api.Core.Pet.DTO.PetRequestDTO;
import com.filipe.vaccination_card_api.Core.Pet.DTO.PetResponseDTO;
import com.filipe.vaccination_card_api.Core.Pet.Services.ChangePetActiveService;
import com.filipe.vaccination_card_api.Core.Pet.Services.CreatePetService;
import com.filipe.vaccination_card_api.Core.Pet.Services.DeletePetService;
import com.filipe.vaccination_card_api.Core.Pet.Services.GetAllPetsService;
import com.filipe.vaccination_card_api.Core.Pet.Services.GetPetService;
import com.filipe.vaccination_card_api.Core.Pet.Services.UpdatePetService;
import com.filipe.vaccination_card_api.Core.Pet.UseCases.GetAllAcitvePets;

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
@RequestMapping("/pets")
public class PetController {
    private final CreatePetService createPetService;
    private final GetPetService getPetService;
    private final GetAllAcitvePets getAllAcitvePetsService;
    private final GetAllPetsService getAllPetsService;
    private final UpdatePetService updatePetService;
    private final ChangePetActiveService changePetActiveService;
    private final DeletePetService deletePetService;

    public PetController(
        CreatePetService createPetService,
        GetPetService getPetService,
        GetAllAcitvePets getAllAcitvePets,
        GetAllPetsService getAllPetsService,
        UpdatePetService updatePetService,
        ChangePetActiveService changePetActiveService,
        DeletePetService deletePetService
    ){
        this.createPetService = createPetService;
        this.getPetService = getPetService;
        this.getAllAcitvePetsService = getAllAcitvePets;
        this.getAllPetsService = getAllPetsService;
        this.updatePetService = updatePetService;
        this.changePetActiveService = changePetActiveService;
        this.deletePetService = deletePetService;
    }

    @PostMapping
    public ResponseEntity<PetResponseDTO> createPet(@RequestBody PetRequestDTO petRequestDTO) {
        Pet pet = new Pet(petRequestDTO.name(), petRequestDTO.image_url());
        pet = createPetService.execute(pet);        
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(new PetResponseDTO(pet.getId(), pet.getName(), pet.getImageUrl(), pet.getActive()));
    }
    
    @GetMapping
    public List<PetResponseDTO> getAllPets() {
        List<Pet> listOfPets = getAllPetsService.execute();
        List<PetResponseDTO> listOfDtos = 
        listOfPets.stream().map(pet -> new PetResponseDTO(pet.getId(), pet.getName(), pet.getImageUrl(), pet.getActive())).toList();

        return listOfDtos;
    }

    @GetMapping("/actives")
    public List<PetResponseDTO> getAllActivePets() {
        List<Pet> listOfPets = getAllAcitvePetsService.execute();
        List<PetResponseDTO> listOfDtos = 
        listOfPets.stream().map(pet -> new PetResponseDTO(pet.getId(), pet.getName(), pet.getImageUrl(), pet.getActive())).toList();
        return listOfDtos;
    }

    @GetMapping("/{id}")
    public PetResponseDTO getMethodName(@PathVariable Integer id) {
        Pet pet = getPetService.execute(id);
        PetResponseDTO petResponseDTO = new PetResponseDTO(id, pet.getName(), pet.getImageUrl(), pet.getActive());
        return petResponseDTO;
    }

    @PutMapping("/{id}")
    public PetResponseDTO updatePet(@PathVariable Integer id, @RequestBody PetRequestDTO petRequestDTO) {
        Pet petToUpdate = new Pet(petRequestDTO.name(), petRequestDTO.image_url());
        Pet updatedPet = updatePetService.execute(petToUpdate, id);
        PetResponseDTO petResponseDTO = new PetResponseDTO(id, updatedPet.getName(), updatedPet.getImageUrl(), updatedPet.getActive());
        return petResponseDTO;
    }

    @PatchMapping("/{id}")
    public Boolean changePetActive(@PathVariable Integer id, @RequestBody Boolean active) {
        changePetActiveService.execute(active, id);

        return true;
    }
    
    @DeleteMapping("/{id}")
    public Boolean deletePet(@PathVariable int id) {
        deletePetService.execute(id);
        return true;
    }
    
    
}