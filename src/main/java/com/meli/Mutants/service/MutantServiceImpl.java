package com.meli.Mutants.service;

import com.meli.Mutants.model.DNADto;
import com.meli.Mutants.util.validator.DNAValidatorImpl;
import org.springframework.stereotype.Service;

@Service
public class MutantServiceImpl implements IMutantService {

    @Override
    public boolean isMutant(DNADto dna) {
        if (!isDNACorrect(dna))
            return false;

        String[][] dnaMatrix = getDnaMatrix(dna);
        return isMutant(dnaMatrix);
    }

    private boolean isDNACorrect(DNADto dna) {
        DNAValidatorImpl validator = new DNAValidatorImpl();
        return validator.isDNANxN(dna) && validator.isACGT(dna);
    }

    private String[][] getDnaMatrix(DNADto dna) {
        String[] dnaArray = dna.getDna();
        String[][] dnaMatrix = new String[dnaArray.length][dnaArray.length];
        for (int indexRow = 0; indexRow < dnaArray.length; indexRow++) {
            String[] columnArray = dnaArray[indexRow].split("");
            System.arraycopy(columnArray, 0, dnaMatrix[indexRow], 0, columnArray.length);
        }
        return dnaMatrix;
    }

    private boolean isMutant(String[][] dnaMatrix) {
        return false;
    }
}