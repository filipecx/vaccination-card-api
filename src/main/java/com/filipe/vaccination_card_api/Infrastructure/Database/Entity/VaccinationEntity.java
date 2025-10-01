package com.filipe.vaccination_card_api.Infrastructure.Database.Entity;

import java.time.LocalDate;

import com.filipe.vaccination_card_api.Core.Pet.Pet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vaccinations")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VaccinationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "nextDate")
    private LocalDate nextAdministration;

    @Column(name = "done")
    private boolean completed;

    @Column(name = "vaccine_name", nullable = false)
    private String vaccineName;

    @Column(name = "vaccine_manufacturer")
    private String vaccineManufacturer;

    @Column(name = "vaccine_batchnumber")
    private String vaccineBatchNumber;

    @Column(name = "veterinarian_name")
    private String veterinarianName;

    @Column(name = "veterinarian_crmv")
    private String veterinarianCrmv;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private PetEntity pet;
}
