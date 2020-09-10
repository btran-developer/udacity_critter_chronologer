package com.udacity.jdnd.course3.critter.schedule.dto;

import com.udacity.jdnd.course3.critter.user.type.EmployeeSkill;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

/**
 * Represents the form that schedule request and response data takes. Does not map
 * to the database directly.
 *
 * ex:
 * {
 *     "employeeIds": [1, 3],
 *     "petIds": [1, 2],
 *     "date": "2019-12-17",
 *     "startTime": "08:00",
 *     "endTime": "09:00",
 *     "activities": ["PETTING", "FEEDING"]
 * }
 */
public class ScheduleDTO {
    private long id;

    @NotEmpty(message = "Employees list cannot be empty")
    private List<Long> employeeIds;

    @NotEmpty(message = "Pets list cannot be empty")
    private List<Long> petIds;

    @NotNull(message = "Schedule date is required.")
    private LocalDate date;

    @NotNull(message = "Start time date is required.")
    private LocalTime startTime;

    @NotNull(message = "End time date is required.")
    private LocalTime endTime;

    @NotEmpty(message = "Schedule activities list cannot be empty")
    private Set<EmployeeSkill> activities;

    public List<Long> getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(List<Long> employeeIds) {
        this.employeeIds = employeeIds;
    }

    public List<Long> getPetIds() {
        return petIds;
    }

    public void setPetIds(List<Long> petIds) {
        this.petIds = petIds;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public LocalTime getStartTime() { return this.startTime; }

    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }

    public LocalTime getEndTime() { return this.endTime; }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<EmployeeSkill> getActivities() {
        return activities;
    }

    public void setActivities(Set<EmployeeSkill> activities) {
        this.activities = activities;
    }
}
