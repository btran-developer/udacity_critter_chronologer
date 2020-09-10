package com.udacity.jdnd.course3.critter.user.repository;

import com.udacity.jdnd.course3.critter.user.entity.Employee;
import com.udacity.jdnd.course3.critter.user.type.EmployeeSkill;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

public interface EmployeeDAO {

    List<Employee> listAllAvailableForService(LocalDate date, LocalTime startTime, LocalTime endTime, Set<EmployeeSkill> skills);
}
