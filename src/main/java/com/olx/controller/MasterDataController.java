package com.olx.controller;

import com.olx.dto.Category;
import com.olx.dto.Status;
import com.olx.service.MasterDataService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/olx/masterdata")
public class MasterDataController {

    @Autowired
    MasterDataService masterDataService;

    @ApiOperation(value = "Returns all categories")
    @GetMapping(value = "/category",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Category>> getCategories() {
        return new ResponseEntity<>(masterDataService.getCategories(), HttpStatus.OK);
    }

    @ApiOperation(value = "Returns a category by id")
    @GetMapping(value = "/category/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") int id) {
        return new ResponseEntity<>(masterDataService.getCategoryById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Returns all status")
    @GetMapping(value = "/status",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Status>> getStatus() {
        return new ResponseEntity<>(masterDataService.getStatus(), HttpStatus.OK);
    }

    @ApiOperation(value = "Returns a status by id")
    @GetMapping(value = "/status/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Status> getStatusById(@PathVariable("id") int id) {
        return new ResponseEntity<>(masterDataService.getStatusById(id), HttpStatus.OK);
    }
}
