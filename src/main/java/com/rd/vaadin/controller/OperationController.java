package com.rd.vaadin.controller;

import com.rd.vaadin.model.Operation;
import com.rd.vaadin.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by DANG DIM
 * Date     : 3/8/2018, 3:41 PM
 * Email    : d.dim@gl-f.com
 */

@RestController
@RequestMapping(value = "api/operations")
public class OperationController {

    @Autowired
    private OperationRepository repository;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> createOperation(@RequestBody Operation operation) {
        if (operation == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            try {
                repository.save(operation);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    @GetMapping
    public ResponseEntity<List<Operation>> getAllOperations() {
        List<Operation> allOperations = repository.findAll();
        if (allOperations.isEmpty()) {
            allOperations = new ArrayList<Operation>(Arrays.<Operation>asList());
            return ResponseEntity.ok(allOperations);
        }
        return ResponseEntity.ok(allOperations);
    }
}
