package com.rd.vaadin.controller;

import com.rd.vaadin.model.ReceiptCode;
import com.rd.vaadin.repository.ReceiptCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by DANG DIM
 * Date     : 3/7/2018, 11:44 AM
 * Email    : d.dim@gl-f.com
 */

@RestController
@RequestMapping(value = "api/receiptcodes")
public class ReceiptCodeController {

    @Autowired
    private ReceiptCodeRepository repository;

    @PostMapping
    public ResponseEntity<ReceiptCode> createReceiptCode(@RequestBody ReceiptCode receiptCode) {
        return new ResponseEntity<>(repository.save(receiptCode), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> allCode() {
        List<ReceiptCode> receiptCodes = repository.findAll();
        if (receiptCodes.isEmpty()) {
            return new ResponseEntity<>("No data in database !", HttpStatus.NOT_FOUND);
        } else
            return new ResponseEntity<>(receiptCodes, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity findOne(@PathVariable Long id) {
        ReceiptCode receiptCode = repository.findOne(id);
        if (receiptCode == null) {
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(receiptCode, HttpStatus.OK);
    }
}
