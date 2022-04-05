package se.iths.charity_shop.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import se.iths.charity_shop.entity.CharityEntity;
import se.iths.charity_shop.entity.EmployeeEntity;
import se.iths.charity_shop.repository.EmployeeRepository;
import java.util.Optional;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeService( EmployeeRepository employeeRepository) {this.employeeRepository = employeeRepository;}

    public EmployeeEntity createEmployee(EmployeeEntity employeeEntity) {return employeeRepository.save(employeeEntity);}


    public void saveOrUpdate(EmployeeEntity employeeEntity)
    {
        employeeRepository.save(employeeEntity);
    }

    public void deleteEmployee(Long id) {
        Optional<EmployeeEntity> foundEmployee = employeeRepository.findById(id);
        employeeRepository.deleteById(id);
    }

    public Optional<EmployeeEntity> findEmployeeById(Long id) {return employeeRepository.findById(id);}

    public Iterable<EmployeeEntity> findAll() {return employeeRepository.findAll();}
}
