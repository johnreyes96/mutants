package com.meli.Mutants.transformer;

import java.util.Arrays;

import com.meli.Mutants.dto.DNADto;
import com.meli.Mutants.model.DNA;

public class DNATransformer {

    public char[][] transformerStringArrayToCharMatrix(String[] dnaArray) {
        char[][] dnaMatrix = new char[dnaArray.length][dnaArray.length];
        for (int indexRow = 0; indexRow < dnaArray.length; indexRow++) {
            String[] rowArray = dnaArray[indexRow].split("");
            for (int indexColumn = 0; indexColumn < rowArray.length; indexColumn++) {
                dnaMatrix[indexRow][indexColumn] = rowArray[indexColumn].charAt(0);
            }
        }
        return dnaMatrix;
    }

    public DNA transformerDNADtoToDNA(DNADto dnaDto, boolean isMutant) {
        DNA dna = new DNA();
        dna.setDna(Arrays.toString(dnaDto.getDna()));
        dna.setMutant(isMutant);
        return dna;
    }
}