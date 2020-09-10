package com.udacity.jdnd.course3.critter.user.service;

import com.udacity.jdnd.course3.critter.schedule.service.ScheduleService;
import com.udacity.jdnd.course3.critter.user.entity.Employee;
import com.udacity.jdnd.course3.critter.user.exception.EmployeeNotFoundException;
import com.udacity.jdnd.course3.critter.user.repository.EmployeeDAOImpl;
import com.udacity.jdnd.course3.critter.user.repository.EmployeeRepository;
import com.udacity.jdnd.course3.critter.user.type.EmployeeSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeDAOImpl employeeDAO;

    @Autowired
    private ScheduleService scheduleService;

    public List<Employee> list() {
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
    }

    /**
     * The function will return employees who don't have any schedules overlap with the
     * requested time
     *
     * @param date (requested date)
     * @param startTime (requested start time)
     * @param endTime (requested end time)
     * @param skills (required skills)
     * @return list of employees who are available at specific point of time during specific date
     */
    public List<Employee> listAllAvailableForService(LocalDate date, LocalTime startTime, LocalTime endTime, Set<EmployeeSkill> skills) {
        return employeeDAO.listAllAvailableForService(date, startTime, endTime, skills)
                .stream()
                .map(employee -> findById(employee.getId()))
                .collect(Collectors.toList());
    }
}
