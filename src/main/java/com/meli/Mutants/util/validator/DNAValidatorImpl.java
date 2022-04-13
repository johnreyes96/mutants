package com.meli.Mutants.util.validator;

import java.util.Arrays;

import com.meli.Mutants.model.DNADto;

public class DNAValidatorImpl implements IDNAValidator {

    /**
     * Valid if the matrix is square and at least 4x4 elements.
     * @param dnaDto matrix {@code DNADto} to check
     * @return {@code true} if the matrix is of NxN elements with at least 4x4 elements
     */
    @Override
    public boolean isDNANxN(DNADto dnaDto) {
        String[] dnaArray = dnaDto.getDna();
        if (dnaArray.length < 4) return false;

        int arrayLength = dnaArray.length;
        for (String dna : dnaArray) {
            if (dna.length() != arrayLength) {
                return false;
            }
        }
        return true;
    }

    /**
     * Valid that the matrix of NxN elements only has ACGT characters.
     * @param dnaDto matrix {@code DNADto} to check
     * @return {@code true} if the matrix has only ACGT characters
     */
    @Override
    public boolean isACGT(DNADto dnaDto) {
        return Arrays.stream(dnaDto.getDna()).allMatch(dnaArray -> dnaArray.matches("(A|C|G|T|a|c|gt)+"));
    }
}