package com.udacity.jdnd.course3.critter.pet.dto;

import com.udacity.jdnd.course3.critter.pet.type.PetType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Represents the form that pet request and response data takes. Does not map
 * to the database directly.
 *
 * ex:
 * {
 *   "type": "CAT",
 *   "name": "Amy",
 *   "birthDate": "2019-12-16",
 *   "notes": "HI Amy",
 *   "ownerId": 1
 * }
 */
public class PetDTO {
    private long id;
    private PetType type;

    @NotBlank(message = "Pet name is required")
    private String name;

    @NotNull(message = "Owner is required")
    private Long ownerId;
    private LocalDate birthDate;
    private String notes;

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
