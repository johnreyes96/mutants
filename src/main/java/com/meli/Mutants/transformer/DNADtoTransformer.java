package com.meli.Mutants.transformer;

import com.meli.Mutants.model.DNADto;

public class DNADtoTransformer {

    public char[][] transformerDNADtoToChar(DNADto dna) {
        String[] dnaArray = dna.getDna();
        char[][] dnaMatrix = new char[dnaArray.length][dnaArray.length];
        for (int indexRow = 0; indexRow < dnaArray.length; indexRow++) {
            String[] rowArray = dnaArray[indexRow].split("");
            for (int indexColumn = 0; indexColumn < rowArray.length; indexColumn++) {
                dnaMatrix[indexRow][indexColumn] = rowArray[indexColumn].charAt(0);
            }
        }
        return dnaMatrix;
    }
}