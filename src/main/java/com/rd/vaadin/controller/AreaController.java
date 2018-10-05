package com.rd.vaadin.controller;

import com.rd.vaadin.model.Area;
import com.rd.vaadin.model.Operation;
import com.rd.vaadin.repository.AreaRepository;
import com.rd.vaadin.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by DANG DIM
 * Date     : 3/13/2018, 12:03 PM
 * Email    : d.dim@gl-f.com
 */

@RestController
@RequestMapping("api/areas")
public class AreaController {

    @Autowired
    private AreaRepository repository;

    @PostMapping
    public ResponseEntity<Area> createOperation(@RequestBody Area area) {
        if (area == null) {
            return ResponseEntity.noContent().build();
        } else{
            return ResponseEntity.ok(repository.save(area));
        }
    }

    @GetMapping
    public ResponseEntity<List<Area>> getAreas() {
        List<Area> allProvinceAreas = repository.findAll();
        if (allProvinceAreas.isEmpty()) {
            allProvinceAreas = new ArrayList<Area>(Arrays.<Area>asList());
            return ResponseEntity.ok(allProvinceAreas);
        }
        return ResponseEntity.ok(allProvinceAreas);
    }

    public ResponseEntity<Area> getAreaByOperation() {
        return null;
    }
}
