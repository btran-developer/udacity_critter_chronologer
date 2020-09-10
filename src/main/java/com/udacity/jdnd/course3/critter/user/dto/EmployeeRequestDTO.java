package com.udacity.jdnd.course3.critter.user.dto;

import com.udacity.jdnd.course3.critter.user.type.EmployeeSkill;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

/**
 * Represents a request to find available employees by skills. Does not map
 * to the database directly.
 *
 * ex:
 * {
 *     "date": "2019-12-17",
 * 	    "skills": ["PETTING", "FEEDING"],
 * 	    "startTime": "09:30",
* 	    "endTime": "10:00"
 * }
 */
public class EmployeeRequestDTO {
    @NotEmpty(message = "Skills list cannot be empty")
    private Set<EmployeeSkill> skills;

    @NotNull(message = "Date is required")
    private LocalDate date;

    @NotNull(message = "Start time is required")
    private LocalTime startTime;

    @NotNull(message = "End time is required")
    private LocalTime endTime;

    public Set<EmployeeSkill> getSkills() {
        return skills;
    }

    public void setSkills(Set<EmployeeSkill> skills) {
        this.skills = skills;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
