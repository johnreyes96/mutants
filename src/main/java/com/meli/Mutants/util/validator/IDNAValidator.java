package com.meli.Mutants.util.validator;

import com.meli.Mutants.model.DNADto;

public interface IDNAValidator {

    boolean isDNANxN(DNADto dnaDto);

    boolean isACGT(DNADto dnaDto);
}