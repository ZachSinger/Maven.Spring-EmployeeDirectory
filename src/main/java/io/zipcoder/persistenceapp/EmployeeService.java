package io.zipcoder.persistenceapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public Employee create(Employee employee){ return repository.save(employee); }

    public Employee read(Long id) { return repository.findOne(id); }

    public List<Employee> readAll(){
        Iterable<Employee> employeeIterable = repository.findAll();
        List<Employee> result = new ArrayList<>();
        employeeIterable.forEach(result::add);
        return result;
    }

    public Employee update(Long id, Employee newEmployeeData){
        Employee employeeInDatabase = read(id);
        employeeInDatabase.setFirstName(newEmployeeData.getFirstName());
        employeeInDatabase.setLastName(newEmployeeData.getLastName());
        employeeInDatabase.setPhoneNumber(newEmployeeData.getPhoneNumber());
        employeeInDatabase.setEmail(newEmployeeData.getEmail());
        employeeInDatabase.setTitle(newEmployeeData.getTitle());
        employeeInDatabase.setManager(newEmployeeData.getManager());
        employeeInDatabase.setHireDate(newEmployeeData.getHireDate());
        return repository.save(employeeInDatabase);
    }

    public Employee delete(Employee employee){
        repository.delete(employee);
        return employee;
    }

    public Employee delete(Long id){
        return delete(read(id));
    }
}
