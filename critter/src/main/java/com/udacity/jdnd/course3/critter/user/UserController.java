package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.entities.Customer;
import com.udacity.jdnd.course3.critter.entities.Employee;
import com.udacity.jdnd.course3.critter.entities.EmployeeSkill;
import com.udacity.jdnd.course3.critter.services.CustomersService;
import com.udacity.jdnd.course3.critter.services.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CustomersService customersService;

    @Autowired
    private EmployeesService employeesService;


    // save customer
    @PostMapping("/customer")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {

        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setNotes(customerDTO.getNotes());

        Customer savedCustomer = customersService.saveCustomer(customer, null);

        CustomerDTO dto = new CustomerDTO();
        dto.setId(savedCustomer.getId());
        dto.setName(savedCustomer.getName());
        dto.setPhoneNumber(savedCustomer.getPhoneNumber());
        dto.setNotes(savedCustomer.getNotes());

        return dto;
    }


    // get all customers
    @GetMapping("/customer")
    public List<CustomerDTO> getAllCustomers() {

        return customersService.getAllCustomers()
                .stream()
                .map(customer -> {

                    CustomerDTO dto = new CustomerDTO();
                    dto.setId(customer.getId());
                    dto.setName(customer.getName());
                    dto.setPhoneNumber(customer.getPhoneNumber());
                    dto.setNotes(customer.getNotes());

                    return dto;
                })
                .collect(Collectors.toList());
    }


    // get owner by pet id
    @GetMapping("/customer/pet/{petId}")
    public CustomerDTO getOwnerByPet(@PathVariable long petId) {

        Customer customer = customersService.getCustomerByPetId(petId);

        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setPhoneNumber(customer.getPhoneNumber());
        dto.setNotes(customer.getNotes());

        return dto;
    }


    // save employee
    @PostMapping("/employee")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {

        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setSkills(employeeDTO.getSkills());
        employee.setDaysAvailable(employeeDTO.getDaysAvailable());

        Employee savedEmployee = employeesService.saveEmployee(employee);

        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(savedEmployee.getId());
        dto.setName(savedEmployee.getName());
        dto.setSkills(savedEmployee.getSkills());
        dto.setDaysAvailable(savedEmployee.getDaysAvailable());

        return dto;
    }


    // get employee by id
    @GetMapping("/employee/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable long employeeId) {

        Employee employee = employeesService.getEmployeeById(employeeId);

        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setSkills(employee.getSkills());
        dto.setDaysAvailable(employee.getDaysAvailable());

        return dto;
    }


    // set employee availability
    @PutMapping("/employee/{employeeId}")
    public void setAvailability(@RequestBody Set<DayOfWeek> daysAvailable,
                                @PathVariable long employeeId) {

        employeesService.setEmployeeAvailability(daysAvailable, employeeId);
    }


    // find employees by availability
    @GetMapping("/employee/availability")
    public List<EmployeeDTO> findEmployeesForService(@RequestBody EmployeeRequestDTO requestDTO) {

        List<Employee> employees =
                employeesService.getEmployeesForService(
                        requestDTO.getDate(),
                        requestDTO.getSkills());

        return employees.stream()
                .map(employee -> {

                    EmployeeDTO dto = new EmployeeDTO();
                    dto.setId(employee.getId());
                    dto.setName(employee.getName());
                    dto.setSkills(employee.getSkills());
                    dto.setDaysAvailable(employee.getDaysAvailable());

                    return dto;
                })
                .collect(Collectors.toList());
    }

}