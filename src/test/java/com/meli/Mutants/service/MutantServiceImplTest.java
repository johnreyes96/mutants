package com.meli.Mutants.service;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import com.meli.Mutants.model.DNADto;

public class MutantServiceImplTest {

    private MutantServiceImpl mutantService;

    @BeforeEach
    void setUp() {
        this.mutantService = Mockito.spy(new MutantServiceImpl());
    }

    @Test
    public void getDnaMatrixWhenDNAIsNullThenMustReturnEmptyMatrixTest() {
        DNADto dna = new DNADto();
        char[][] expected = new char[0][];

        char[][] dnaMatrix = mutantService.getDnaMatrix(dna);

        Assertions.assertEquals(expected.length, dnaMatrix.length);
    }

    @Test
    public void getDnaMatrixWhenDNAHaveOneArrayWith1ItemThenMustReturn1x1MatrixTest() {
        DNADto dna = new DNADto();
        String[] dnaArray = new String[1];
        dnaArray[0] = "A";
        dna.setDna(dnaArray);
        char[][] expected = new char[1][1];
        expected[0][0] = 'A';

        char[][] dnaMatrix = mutantService.getDnaMatrix(dna);

        Assertions.assertEquals(expected[0][0], dnaMatrix[0][0]);
    }

    @Test
    public void getDnaMatrixWhenDNAHave3ArraysWith3ItemsThenMustReturn3x3MatrixTest() {
        DNADto dna = new DNADto();
        String[] dnaArray = new String[3];
        dnaArray[0] = "ATG";
        dnaArray[1] = "CAG";
        dnaArray[2] = "TTA";
        dna.setDna(dnaArray);
        char[][] expected = new char[3][3];
        expected[0][0] = 'A';
        expected[0][1] = 'T';
        expected[0][2] = 'G';
        expected[1][0] = 'C';
        expected[1][1] = 'A';
        expected[1][2] = 'G';
        expected[2][0] = 'T';
        expected[2][1] = 'T';
        expected[2][2] = 'A';

        char[][] dnaMatrix = mutantService.getDnaMatrix(dna);

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

    @AfterEach
    void tearDown() {
        this.mutantService = null;
    }
}