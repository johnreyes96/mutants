package com.meli.Mutants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meli.Mutants.dto.DNADto;
import com.meli.Mutants.model.DNA;
import com.meli.Mutants.service.StatsServiceImpl;
import com.meli.Mutants.transformer.DNATransformer;
import com.meli.Mutants.service.MutantServiceImpl;

import java.util.Arrays;

@RestController
@RequestMapping(MutantController.ROUTE)
public class MutantController {

    public static final String ROUTE = "/mutant/";

    @Autowired
    private MutantServiceImpl mutantService;

    @Autowired
    private StatsServiceImpl statsService;

    @PostMapping
    public ResponseEntity<Void> isMutant(@RequestBody DNADto dnaDto) {
        DNA dna = statsService.findDNAByDNA(Arrays.toString(dnaDto.getDna()));
        if (dna != null) {
            return buildResponseEntity(dna.isMutant());
        }
        boolean isMutant = mutantService.isMutant(dnaDto.getDna());
        saveDNA(dnaDto, isMutant);
        return buildResponseEntity(isMutant);
    }

    private ResponseEntity<Void> buildResponseEntity(boolean isMutant) {
        return isMutant
                ? new ResponseEntity<>(null, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }

    protected void saveDNA(DNADto dnaDto, boolean isMutant) {
        statsService.saveDNA(new DNATransformer().transformerDNADtoToDNA(dnaDto, isMutant));
    }
}