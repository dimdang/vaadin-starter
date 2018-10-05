package com.rd.vaadin.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rd.vaadin.model.Area;
import com.rd.vaadin.model.Operation;
import com.rd.vaadin.model.ReceiptCode;
import com.rd.vaadin.repository.ReceiptCodeRepository;
import com.rd.vaadin.util.RouteUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by DANG DIM
 * Date     : 3/8/2018, 3:11 PM
 * Email    : d.dim@gl-f.com
 */

public class HttpMethodsUtil {

    private RestTemplate restTemplate = new RestTemplate();
    private Logger logger = Logger.getLogger(String.valueOf(HttpMethodsUtil.class));

    public List<Operation> doGetOperation() {
        ResponseEntity<List> responseEntity = restTemplate.getForEntity(URI.create(RouteUtil.API_OPERATION), List.class);
        return new ObjectMapper().convertValue(responseEntity.getBody().toArray(), new TypeReference<List<Operation>>() {
        });
    }

    public void doPostOperations(Operation operation) {
        ResponseEntity<HttpStatus> responseEntity = restTemplate.postForEntity(URI.create(RouteUtil.API_OPERATION), operation, HttpStatus.class);
        if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
            logger.info("Well done..!");
        }
    }

    public List<ReceiptCode> doGetReceiptCode() {
        ResponseEntity<List> responseEntity = restTemplate.getForEntity(URI.create(RouteUtil.API_RECEIPT_CODE), List.class);
        return new ObjectMapper().convertValue(responseEntity.getBody().toArray(), new TypeReference<List<ReceiptCode>>() {
        });
    }

    public List<Area> doGetArea() {
        ResponseEntity<List> responseEntity = restTemplate.getForEntity(URI.create(RouteUtil.API_AREA), List.class);
        return new ObjectMapper().convertValue(responseEntity.getBody().toArray(), new TypeReference<List<Area>>() {
        });
    }
}
