package com.meli.Mutants.transformer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.meli.Mutants.dto.DNADto;
import com.meli.Mutants.factory.DNADtoFactory;
import com.meli.Mutants.model.DNA;
import com.meli.Mutants.factory.DNAMatrixFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DNATransformerTest {

    private DNATransformer dnaTransformer;

    @BeforeEach
    void setUp() {
        this.dnaTransformer = Mockito.spy(new DNATransformer());
    }

    @Test
    public void getDnaMatrixWhenDNAArrayHas3ItemsThenMustReturn3x3MatrixTest() {
        String[] dnaArray = DNAMatrixFactory.getDnaArray3x3();
        char[][] expected = DNAMatrixFactory.getDnaMatrix3x3();

        char[][] dnaMatrix = dnaTransformer.transformerStringArrayToCharMatrix(dnaArray);

        assertEquals(expected[0][0], dnaMatrix[0][0]);
        assertEquals(expected[0][1], dnaMatrix[0][1]);
        assertEquals(expected[0][2], dnaMatrix[0][2]);
        assertEquals(expected[1][0], dnaMatrix[1][0]);
        assertEquals(expected[1][1], dnaMatrix[1][1]);
        assertEquals(expected[1][2], dnaMatrix[1][2]);
        assertEquals(expected[2][0], dnaMatrix[2][0]);
        assertEquals(expected[2][1], dnaMatrix[2][1]);
        assertEquals(expected[2][2], dnaMatrix[2][2]);
    }

    @Test
    public void transformerDNADtoToDNAWhenIsMutantThenMustReturnDNATest() {
        DNADto dnaDto = DNADtoFactory.unDNADto().conDNA(DNAMatrixFactory.getDnaArray6x6()).getInstance();
        String dnaExpected = "[ATGCGA, CAGTGC, TTATGT, AGAAGG, CCCCTA, TCACTG]";

        DNA dna = dnaTransformer.transformerDNADtoToDNA(dnaDto, true);

        assertEquals(dnaExpected, dna.getDna());
        Assertions.assertTrue(dna.isMutant());
    }

    @AfterEach
    void tearDown() {
        this.dnaTransformer = null;
    }
}