package com.meli.Mutants.service;

import com.meli.Mutants.model.DNADto;
import org.springframework.stereotype.Service;

@Service
public class MutantServiceImpl implements IMutantService {

    @Override
    public boolean isMutant(DNADto dna) {
        return false;
    }
}