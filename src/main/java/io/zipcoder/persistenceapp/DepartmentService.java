package io.zipcoder.persistenceapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository repository;

    public Department create(Department department) { return repository.save(department); }

    public Department read(Long id) {return repository.findOne(id); }

    public List<Department> readAll(){
        Iterable<Department> departmentIterable = repository.findAll();
        List<Department> result = new ArrayList<>();
        departmentIterable.forEach(result::add);
        return result;
    }

    public Department update(Long id, Department newDepartmentData){
        Department departmentInDatabase = read(id);
        departmentInDatabase.setDepartmentName(newDepartmentData.getDepartmentName());
        departmentInDatabase.setDepartmentManager(newDepartmentData.getDepartmentManager());
        return repository.save(departmentInDatabase);
    }

    public Department delete(Department department){
        repository.delete(department);
        return department;
    }

    public Department delete(Long id){
        return delete(read(id));
    }
}
