package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.entities.Schedule;
import com.udacity.jdnd.course3.critter.services.SchedulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Schedules.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private SchedulesService schedulesService;


    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {

        Schedule schedule = new Schedule();

        schedule.setDate(scheduleDTO.getDate());
        schedule.setActivities(scheduleDTO.getActivities());

        Schedule savedSchedule =
                schedulesService.saveSchedule(
                        schedule,
                        scheduleDTO.getEmployeeIds(),
                        scheduleDTO.getPetIds()
                );

        scheduleDTO.setId(savedSchedule.getId());

        return scheduleDTO;
    }


    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {

        return schedulesService.getAllSchedules()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    @GetMapping("/pet/{petId}")
    public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {

        return schedulesService.getAllSchedulesForPet(petId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {

        return schedulesService.getAllSchedulesForEmployee(employeeId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {

        return schedulesService.getAllSchedulesForCustomer(customerId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }



    private ScheduleDTO convertToDTO(Schedule schedule){

        ScheduleDTO dto = new ScheduleDTO();

        dto.setId(schedule.getId());
        dto.setActivities(schedule.getActivities());
        dto.setDate(schedule.getDate());

        dto.setEmployeeIds(
                schedule.getEmployees()
                        .stream()
                        .map(employee -> employee.getId())
                        .collect(Collectors.toList())
        );

        dto.setPetIds(
                schedule.getPets()
                        .stream()
                        .map(pet -> pet.getId())
                        .collect(Collectors.toList())
        );

        return dto;
    }

}