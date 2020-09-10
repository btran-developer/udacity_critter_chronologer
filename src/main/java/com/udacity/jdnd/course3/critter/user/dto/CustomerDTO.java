package com.udacity.jdnd.course3.critter.user.dto;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * Represents the form that customer request and response data takes. Does not map
 * to the database directly.
 *
 * ex:
 * {
 *     "id": 1,
 *     "name": "Alex",
 *     "phoneNumber": "1234567890",
 *     "notes": null,
 *     "petIds": [1, 2]
 * }
 */
public class CustomerDTO {
    private long id;

    @NotBlank(message = "Customer name is required")
    private String name;
    private String phoneNumber;
    private String notes;
    private List<Long> petIds;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Long> getPetIds() {
        return petIds;
    }

    public void setPetIds(List<Long> petIds) {
        this.petIds = petIds;
    }
}
