package io.zipcoder.persistenceapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/API/department-controller")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @PostMapping(value = "/create")
    public ResponseEntity<Department> create(@RequestBody Department department){
        return new ResponseEntity<>(service.create(department), HttpStatus.CREATED);
    }
}
