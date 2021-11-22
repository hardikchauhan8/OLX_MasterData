package com.olx.controller;

import com.olx.dto.Category;
import com.olx.dto.Status;
import com.olx.service.MasterDataService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("olx")
public class MasterDataController {

    @Autowired
    MasterDataService masterDataService;

    @ApiOperation(value = "Returns all categories")
    @GetMapping(value = "/advertise/category",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Category> getCategories() {
        return masterDataService.getCategories();
    }

    @ApiOperation(value = "Returns a category by id")
    @GetMapping(value = "/advertise/category/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Category getCategoryById(@PathVariable("id") int id) {
        return masterDataService.getCategoryById(id);
    }

    @ApiOperation(value = "Returns all status")
    @GetMapping(value = "/advertise/status",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Status> getStatus() {
        return masterDataService.getStatus();
    }

    @ApiOperation(value = "Returns a status by id")
    @GetMapping(value = "/advertise/status/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Status getStatusById(@PathVariable("id") int id) {
        return masterDataService.getStatusById(id);
    }
}
