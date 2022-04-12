package com.meli.Mutants.util.validator;

import com.meli.Mutants.model.DNADto;

public class DNAValidatorImpl implements IDNAValidator {

    @Override
    public boolean isDNANxN(DNADto dnaDto) {
        return true;
    }

    @Override
    public boolean isACGT(DNADto dnaDto) {
        return true;
    }
}