package com.meli.Mutants.service;

import com.meli.Mutants.model.DNADto;
import com.meli.Mutants.util.validator.DNAValidatorImpl;
import com.meli.Mutants.util.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class MutantServiceImpl implements IMutantService {

    @Override
    public boolean isMutant(DNADto dna) {
        if (!isDNACorrect(dna))
            return false;

        char[][] dnaMatrix = getDnaMatrix(dna);
        return isMutant(dnaMatrix);
    }

    private boolean isDNACorrect(DNADto dna) {
        DNAValidatorImpl validator = new DNAValidatorImpl();
        return validator.isDNANxN(dna) && validator.isACGT(dna);
    }

    protected char[][] getDnaMatrix(DNADto dna) {
        String[] dnaArray = dna.getDna();
        if (StringUtils.isEmpty(dnaArray)) return new char[0][];

        char[][] dnaMatrix = new char[dnaArray.length][dnaArray.length];
        for (int indexRow = 0; indexRow < dnaArray.length; indexRow++) {
            String[] rowArray = dnaArray[indexRow].split("");
            for (int indexColumn = 0; indexColumn < rowArray.length; indexColumn++) {
                dnaMatrix[indexRow][indexColumn] = rowArray[indexColumn].charAt(0);
            }
        }
        return dnaMatrix;
    }

    private boolean isMutant(char[][] dnaMatrix) {
        return false;
    }
}