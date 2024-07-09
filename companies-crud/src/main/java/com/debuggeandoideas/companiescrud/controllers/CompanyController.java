package com.debuggeandoideas.companiescrud.controllers;

import com.debuggeandoideas.companiescrud.entities.Company;
import com.debuggeandoideas.companiescrud.services.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping(path = "company", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class CompanyController {

    private final CompanyService companyService;
    @Operation(summary = "obtén la información de la compañia")
    @GetMapping(path = "{name}")
    public ResponseEntity<Company> get(@PathVariable String name){
        log.info("Get company with name {}", name);
        return ResponseEntity.ok(this.companyService.readByName(name));
    }

    @PostMapping()
    public ResponseEntity<Company> create(@RequestBody Company company){
        log.info("Create company with name {}", company.getName());
        return ResponseEntity.created(URI.create(this.companyService.create(company).getName())).build();
    }

    @PutMapping(path = "{name}")
    public ResponseEntity<Company> put(@RequestBody Company company, @PathVariable String name){
        log.info("Get company with name {}", name);
        return ResponseEntity.ok(this.companyService.update(company, name));
    }
    @DeleteMapping(path = "{name}")
    public ResponseEntity<?> delete(@PathVariable String name){
        log.info("Delete company with name {}", name);
        this.companyService.delete(name);
        return ResponseEntity.noContent().build();
    }

}
