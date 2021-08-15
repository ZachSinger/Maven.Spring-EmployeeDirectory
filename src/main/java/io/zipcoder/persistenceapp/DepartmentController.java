package io.zipcoder.persistenceapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/API/department-controller")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @PostMapping(value = "/create")
    public ResponseEntity<Department> create(@RequestBody Department department){
        return new ResponseEntity<>(service.create(department), HttpStatus.CREATED);
    }

    @GetMapping(value = "/read")
    public ResponseEntity<List<Department>> readAll(){ return new ResponseEntity<>(service.readAll(), HttpStatus.OK); }

    @GetMapping(value = "/read/{id}")
    public ResponseEntity<Department> read(@PathVariable Long id){
        return new ResponseEntity<>(service.read(id), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Department> update(@PathVariable Long id, @RequestBody Department department){
        return new ResponseEntity<>(service.update(id, department), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Department> delete (@PathVariable Long id){
            return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
