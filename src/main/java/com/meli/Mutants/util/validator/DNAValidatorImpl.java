package com.meli.Mutants.util.validator;

import java.util.Arrays;

public class DNAValidatorImpl implements IDNAValidator {

    /**
     * Valid if the matrix is square and at least 4x4 elements.
     * @param dnaDto matrix {@code DNADto} to check
     * @return {@code true} if the matrix is of NxN elements with at least 4x4 elements
     */
    @Override
    public boolean isDNANxN(String[] dnaDto) {
        if (dnaDto.length < 4) return false;

        int arrayLength = dnaDto.length;
        for (String dna : dnaDto) {
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
    public boolean isACGT(String[] dnaDto) {
        return Arrays.stream(dnaDto).allMatch(dnaArray -> dnaArray.matches("(A|C|G|T|a|c|gt)+"));
    }
}