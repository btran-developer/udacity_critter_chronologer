package com.udacity.jdnd.course3.critter.schedule.service;

import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;
import com.udacity.jdnd.course3.critter.schedule.exception.ScheduleNotFoundException;
import com.udacity.jdnd.course3.critter.schedule.repository.ScheduleRepository;
import com.udacity.jdnd.course3.critter.user.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private EmployeeService employeeService;

    public List<Schedule> list() {
        return scheduleRepository.findAll();
    }

    public Schedule save(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public Optional<Schedule> findById(Long id) { return scheduleRepository.findById(id); }

    public List<Schedule> listAllWithPet(Long petId) {
        return scheduleRepository.findAllByPetsId(petId);
    }

    public List<Schedule> listAllWithEmployee(Long employeeId) {
        return scheduleRepository.findAllByEmployeesId(employeeId);
    }

    public List<Schedule> listAllWithCustomer(Long customerId) {
        return scheduleRepository.findAllByPetsOwnerId(customerId);
    }

    public void deleteSchedule(Schedule schedule) {
        scheduleRepository.findById(schedule.getId()).orElseThrow(ScheduleNotFoundException::new);
        scheduleRepository.delete(schedule);
    }
}
