package com.filipe.vaccination_card_api.Core.Pet;

import com.filipe.vaccination_card_api.Core.Pet.EntityError.PetError;

public class Pet {

    private Integer id;
    private String name;
    private String image_url;
    private boolean active;

    public Pet(String name, String image_url) {
        this.validateName(name);
        this.name = name;
        this.image_url = image_url;
        this.active = true;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getImageUrl() {
        return this.image_url;
    }

    public boolean getActive() {
        return this.active;
    }

    public void changeActive(boolean active) {
        this.active = active;
    }

    public void changePetName(String newName) {
        this.validateName(newName);
        this.name = newName;
    }

    public void changeImageUrl(String newUrl) {
        this.image_url = newUrl;
    }

    private void validateName(String name) {
        if (name.length() < 2) {
            throw new PetError("The name must have at least two characters");
        }
    }


}
