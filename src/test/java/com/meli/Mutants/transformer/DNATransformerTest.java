package com.meli.Mutants.transformer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.meli.Mutants.factory.DNAMatrixFactory;

public class DNATransformerTest {

    @Test
    public void getDnaMatrixWhenDNAArrayHas3ItemsThenMustReturn3x3MatrixTest() {
        String[] dnaArray = DNAMatrixFactory.getDnaArray3x3();
        char[][] expected = DNAMatrixFactory.getDnaMatrix3x3();

        char[][] dnaMatrix = new DNATransformer().transformerStringArrayToCharMatrix(dnaArray);

        Assertions.assertEquals(expected[0][0], dnaMatrix[0][0]);
        Assertions.assertEquals(expected[0][1], dnaMatrix[0][1]);
        Assertions.assertEquals(expected[0][2], dnaMatrix[0][2]);
        Assertions.assertEquals(expected[1][0], dnaMatrix[1][0]);
        Assertions.assertEquals(expected[1][1], dnaMatrix[1][1]);
        Assertions.assertEquals(expected[1][2], dnaMatrix[1][2]);
        Assertions.assertEquals(expected[2][0], dnaMatrix[2][0]);
        Assertions.assertEquals(expected[2][1], dnaMatrix[2][1]);
        Assertions.assertEquals(expected[2][2], dnaMatrix[2][2]);
    }
}