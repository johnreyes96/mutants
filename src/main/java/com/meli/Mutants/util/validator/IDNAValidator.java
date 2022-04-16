package com.meli.Mutants.util.validator;

public interface IDNAValidator {

    boolean isDNANxN(String[] dnaDto);

    boolean isACGT(String[] dnaDto);
}