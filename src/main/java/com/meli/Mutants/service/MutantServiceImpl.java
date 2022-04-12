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

    /**
     * Checks if a human is a mutant.
     * @param dnaMatrix matrix {@code char[][]} NxN elements with characters ACGT to check
     * @return {@code true} if there is more than one sequence of four identical letters,
     * obliquely, horizontally, or vertically
     */
    protected boolean isMutant(char[][] dnaMatrix) {
        for (char[] matrix : dnaMatrix) {
            for (int indexColumn = 0; indexColumn < matrix.length - 3; indexColumn++) {
                if (matrix[indexColumn] == matrix[indexColumn + 1]
                        && matrix[indexColumn] == matrix[indexColumn + 2]
                        && matrix[indexColumn] == matrix[indexColumn + 3]) {
                    return true;
                }
            }
        }
        for (int indexRow = 0; indexRow < dnaMatrix.length - 3; indexRow++) {
            for (int indexColumn = 0; indexColumn < dnaMatrix[indexRow].length; indexColumn++) {
                if (dnaMatrix[indexRow][indexColumn] == dnaMatrix[indexRow + 1][indexColumn]
                        && dnaMatrix[indexRow][indexColumn] == dnaMatrix[indexRow + 2][indexColumn]
                        && dnaMatrix[indexRow][indexColumn] == dnaMatrix[indexRow + 3][indexColumn]) {
                    return true;
                }
            }
        }
        for (int indexRow = 0; indexRow < dnaMatrix.length - 3; indexRow++) {
            for (int indexColumn = 0; indexColumn < dnaMatrix[indexRow].length - 3; indexColumn++) {
                if (dnaMatrix[indexRow][indexColumn] == dnaMatrix[indexRow + 1][indexColumn + 1]
                        && dnaMatrix[indexRow][indexColumn] == dnaMatrix[indexRow + 2][indexColumn + 2]
                        && dnaMatrix[indexRow][indexColumn] == dnaMatrix[indexRow + 3][indexColumn + 3]) {
                    return true;
                }
            }
        }
        for (int indexRow = 0; indexRow < dnaMatrix.length - 3; indexRow++) {
            for (int indexColumn = dnaMatrix[indexRow].length - 1; indexColumn >= dnaMatrix[indexRow].length - 3; indexColumn--) {
                if (dnaMatrix[indexRow][indexColumn] == dnaMatrix[indexRow + 1][indexColumn - 1]
                        && dnaMatrix[indexRow][indexColumn] == dnaMatrix[indexRow + 2][indexColumn - 2]
                        && dnaMatrix[indexRow][indexColumn] == dnaMatrix[indexRow + 3][indexColumn - 3]) {
                    return true;
                }
            }
        }
        return false;
    }
}