package com.meli.Mutants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meli.Mutants.model.DNADto;
import com.meli.Mutants.service.MutantServiceImpl;

@RestController
@RequestMapping(MutantController.ROUTE)
public class MutantController {

    public static final String ROUTE = "/mutant/";

    @Autowired
    private MutantServiceImpl mutantService;

    @PostMapping
    public boolean isMutant(@RequestBody DNADto dnaDto) {
        return mutantService.isMutant(dnaDto);
    }
}