package se.iths.charity_shop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.charity_shop.entity.EmployeeEntity;
import se.iths.charity_shop.service.EmployeeService;
import java.util.Optional;

@RestController
@RequestMapping("employees")

public class EmployeeController {

    EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){this.employeeService = employeeService;}

    @PostMapping
    public ResponseEntity<EmployeeEntity> createEmployee(@RequestBody EmployeeEntity employeeEntity){
        EmployeeEntity createdEmployee = employeeService.createEmployee(employeeEntity);
        return new ResponseEntity(createdEmployee, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable Long id){employeeService.deleteEmployee(id);}

    @GetMapping("{id}")
    public Optional<EmployeeEntity> findEmployeeById(@PathVariable Long id){
        return employeeService.findEmployeeById(id);
    }

    @GetMapping
    public Iterable<EmployeeEntity> findAll(){return employeeService.findAll();}
}
