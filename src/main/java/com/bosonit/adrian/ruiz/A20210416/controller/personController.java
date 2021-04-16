package com.bosonit.adrian.ruiz.A20210416.controller;

import com.bosonit.adrian.ruiz.A20210416.persistence.service.personService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bosonit.adrian.ruiz.A20210416.model.person.person;

@RestController
@RequestMapping("person")
public class personController {

    @Autowired
    private personService ps;

    @ApiOperation(value = "Creates a person and retrieves it back with given age + 1")
    @ApiResponse(code = 200, message = "", response = person.class)
    @PostMapping("/birthday")
    public ResponseEntity<?> birthday(@RequestBody person person) {
        return new ResponseEntity(ps.birthdaySrvc(person), HttpStatus.OK);
    }

    @ApiOperation(value = "Generates a person object via headers")
    @ApiResponse(code = 200, message = "", response = Boolean.class)
    @PostMapping("/genPersonByHeaders")
    public ResponseEntity<?> genPersonByHeaders(@RequestHeader("name") String name,
                                                @RequestHeader("town") String town,
                                                @RequestHeader("age") Integer age) {
        return new ResponseEntity(ps.genPersonByHeadersSrvc(name, town, age), HttpStatus.OK);
    }

    @ApiOperation(value = "Gets a person object with its age multiplied by an X factor")
    @ApiResponses({
            @ApiResponse(code = 200, message = "", response = person.class),
            @ApiResponse(code = 404, message = "The person named \"+ person.name() +\" doesn't exist")
    })
    @GetMapping("/oldifier/{name}/{multFactor}")
    public ResponseEntity<?> oldifier(@PathVariable String name,
                                      @PathVariable Integer multFactor) {
        return new ResponseEntity(ps.oldifierSrvc(name, multFactor), HttpStatus.OK);
    }

    @ApiOperation(value = "Says hello to the requested person")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Hello + \"person.name()\""),
            @ApiResponse(code = 404, message = "The person named \"+ person.name() +\" doesn't exist")
    })
    @GetMapping("/user/{name}")
    public ResponseEntity<?> greetings(@PathVariable String name) {
        return new ResponseEntity(ps.greetingsSrvc(name), HttpStatus.OK);
    }

    @ApiOperation(value = "Creates a person object")
    @ApiResponse(code = 200, message = "", response = Boolean.class)
    @PostMapping("/useradd")
    public ResponseEntity<?> personAdd(@RequestBody person person) {
        return new ResponseEntity(ps.personAddSrvc(person), HttpStatus.OK);
    }
}
