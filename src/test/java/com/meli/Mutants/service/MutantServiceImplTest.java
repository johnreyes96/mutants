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

    @Test
    public void isMutantWhenDNAMatrixIsEmptyThenMustReturnFalseTest() {
        char[][] dnaMatrix = new char[0][];

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertFalse(result);
    }

    @Test
    public void isMutantWhenDNAMatrixIsSmallerOf4x4ThenMustReturnFalseTest() {
        char[][] dnaMatrix = new char[3][3];
        dnaMatrix[0][0] = 'A';
        dnaMatrix[0][1] = 'T';
        dnaMatrix[0][2] = 'G';
        dnaMatrix[1][0] = 'C';
        dnaMatrix[1][1] = 'A';
        dnaMatrix[1][2] = 'G';
        dnaMatrix[2][0] = 'T';
        dnaMatrix[2][1] = 'T';
        dnaMatrix[2][2] = 'A';

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertFalse(result);
    }

    @Test
    public void isMutantWhenDNAMatrixIs4x4AndHaveObliqueSequenceFourEqualLettersThenMustReturnTrueTest() {
        char[][] dnaMatrix = new char[4][4];
        dnaMatrix[0][0] = 'A';
        dnaMatrix[0][1] = 'T';
        dnaMatrix[0][2] = 'G';
        dnaMatrix[0][3] = 'C';
        dnaMatrix[1][0] = 'C';
        dnaMatrix[1][1] = 'A';
        dnaMatrix[1][2] = 'G';
        dnaMatrix[1][3] = 'T';
        dnaMatrix[2][0] = 'T';
        dnaMatrix[2][1] = 'T';
        dnaMatrix[2][2] = 'A';
        dnaMatrix[2][3] = 'T';
        dnaMatrix[3][0] = 'A';
        dnaMatrix[3][1] = 'G';
        dnaMatrix[3][2] = 'A';
        dnaMatrix[3][3] = 'A';

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @Test
    public void isMutantWhenDNAMatrixIs4x4AndHaveOblique2SequenceFourEqualLettersThenMustReturnTrueTest() {
        char[][] dnaMatrix = new char[4][4];
        dnaMatrix[0][0] = 'C';
        dnaMatrix[0][1] = 'G';
        dnaMatrix[0][2] = 'T';
        dnaMatrix[0][3] = 'A';
        dnaMatrix[1][0] = 'T';
        dnaMatrix[1][1] = 'G';
        dnaMatrix[1][2] = 'A';
        dnaMatrix[1][3] = 'C';
        dnaMatrix[2][0] = 'T';
        dnaMatrix[2][1] = 'A';
        dnaMatrix[2][2] = 'T';
        dnaMatrix[2][3] = 'T';
        dnaMatrix[3][0] = 'A';
        dnaMatrix[3][1] = 'A';
        dnaMatrix[3][2] = 'G';
        dnaMatrix[3][3] = 'A';

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @Test
    public void isMutantWhenDNAMatrixIs4x4AndHaveSequenceFourEqualLettersVerticalThenMustReturnTrueTest() {
        char[][] dnaMatrix = new char[4][4];
        dnaMatrix[0][0] = 'G';
        dnaMatrix[0][1] = 'C';
        dnaMatrix[0][2] = 'G';
        dnaMatrix[0][3] = 'A';
        dnaMatrix[1][0] = 'G';
        dnaMatrix[1][1] = 'T';
        dnaMatrix[1][2] = 'G';
        dnaMatrix[1][3] = 'C';
        dnaMatrix[2][0] = 'A';
        dnaMatrix[2][1] = 'T';
        dnaMatrix[2][2] = 'G';
        dnaMatrix[2][3] = 'T';
        dnaMatrix[3][0] = 'A';
        dnaMatrix[3][1] = 'A';
        dnaMatrix[3][2] = 'G';
        dnaMatrix[3][3] = 'G';

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @Test
    public void isMutantWhenDNAMatrixIs4x4AndHaveSequenceFourEqualLettersHorizontalThenMustReturnTrueTest() {
        char[][] dnaMatrix = new char[4][4];
        dnaMatrix[0][0] = 'T';
        dnaMatrix[0][1] = 'T';
        dnaMatrix[0][2] = 'A';
        dnaMatrix[0][3] = 'T';
        dnaMatrix[1][0] = 'A';
        dnaMatrix[1][1] = 'G';
        dnaMatrix[1][2] = 'A';
        dnaMatrix[1][3] = 'A';
        dnaMatrix[2][0] = 'C';
        dnaMatrix[2][1] = 'C';
        dnaMatrix[2][2] = 'C';
        dnaMatrix[2][3] = 'C';
        dnaMatrix[3][0] = 'T';
        dnaMatrix[3][1] = 'C';
        dnaMatrix[3][2] = 'A';
        dnaMatrix[3][3] = 'C';

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @Test
    public void isMutantWhenDNAMatrixIs6x6AndHaveObliqueSequenceFourEqualLettersThenMustReturnTrueTest() {
        char[][] dnaMatrix = new char[6][6];
        dnaMatrix[0][0] = 'A';
        dnaMatrix[0][1] = 'T';
        dnaMatrix[0][2] = 'G';
        dnaMatrix[0][3] = 'C';
        dnaMatrix[0][4] = 'G';
        dnaMatrix[0][5] = 'A';
        dnaMatrix[1][0] = 'C';
        dnaMatrix[1][1] = 'A';
        dnaMatrix[1][2] = 'G';
        dnaMatrix[1][3] = 'T';
        dnaMatrix[1][4] = 'G';
        dnaMatrix[1][5] = 'C';
        dnaMatrix[2][0] = 'T';
        dnaMatrix[2][1] = 'T';
        dnaMatrix[2][2] = 'A';
        dnaMatrix[2][3] = 'T';
        dnaMatrix[2][4] = 'G';
        dnaMatrix[2][5] = 'T';
        dnaMatrix[3][0] = 'A';
        dnaMatrix[3][1] = 'G';
        dnaMatrix[3][2] = 'A';
        dnaMatrix[3][3] = 'A';
        dnaMatrix[3][4] = 'C';
        dnaMatrix[3][5] = 'G';
        dnaMatrix[4][0] = 'C';
        dnaMatrix[4][1] = 'T';
        dnaMatrix[4][2] = 'C';
        dnaMatrix[4][3] = 'C';
        dnaMatrix[4][4] = 'T';
        dnaMatrix[4][5] = 'A';
        dnaMatrix[5][0] = 'T';
        dnaMatrix[5][1] = 'C';
        dnaMatrix[5][2] = 'A';
        dnaMatrix[5][3] = 'C';
        dnaMatrix[5][4] = 'T';
        dnaMatrix[5][5] = 'G';

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @Test
    public void isMutantWhenDNAMatrixIs6x6AndHaveOblique2SequenceFourEqualLettersThenMustReturnTrueTest() {
        char[][] dnaMatrix = new char[6][6];
        dnaMatrix[0][0] = 'A';
        dnaMatrix[0][1] = 'T';
        dnaMatrix[0][2] = 'G';
        dnaMatrix[0][3] = 'C';
        dnaMatrix[0][4] = 'G';
        dnaMatrix[0][5] = 'A';
        dnaMatrix[1][0] = 'C';
        dnaMatrix[1][1] = 'A';
        dnaMatrix[1][2] = 'G';
        dnaMatrix[1][3] = 'T';
        dnaMatrix[1][4] = 'G';
        dnaMatrix[1][5] = 'A';
        dnaMatrix[2][0] = 'T';
        dnaMatrix[2][1] = 'T';
        dnaMatrix[2][2] = 'A';
        dnaMatrix[2][3] = 'T';
        dnaMatrix[2][4] = 'C';
        dnaMatrix[2][5] = 'T';
        dnaMatrix[3][0] = 'A';
        dnaMatrix[3][1] = 'G';
        dnaMatrix[3][2] = 'C';
        dnaMatrix[3][3] = 'C';
        dnaMatrix[3][4] = 'G';
        dnaMatrix[3][5] = 'G';
        dnaMatrix[4][0] = 'C';
        dnaMatrix[4][1] = 'T';
        dnaMatrix[4][2] = 'C';
        dnaMatrix[4][3] = 'C';
        dnaMatrix[4][4] = 'T';
        dnaMatrix[4][5] = 'A';
        dnaMatrix[5][0] = 'T';
        dnaMatrix[5][1] = 'C';
        dnaMatrix[5][2] = 'A';
        dnaMatrix[5][3] = 'C';
        dnaMatrix[5][4] = 'T';
        dnaMatrix[5][5] = 'G';

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @Test
    public void isMutantWhenDNAMatrixIs6x6AndHaveSequenceFourEqualLettersVerticalThenMustReturnTrueTest() {
        char[][] dnaMatrix = new char[6][6];
        dnaMatrix[0][0] = 'T';
        dnaMatrix[0][1] = 'T';
        dnaMatrix[0][2] = 'G';
        dnaMatrix[0][3] = 'C';
        dnaMatrix[0][4] = 'G';
        dnaMatrix[0][5] = 'A';
        dnaMatrix[1][0] = 'C';
        dnaMatrix[1][1] = 'A';
        dnaMatrix[1][2] = 'G';
        dnaMatrix[1][3] = 'T';
        dnaMatrix[1][4] = 'G';
        dnaMatrix[1][5] = 'C';
        dnaMatrix[2][0] = 'T';
        dnaMatrix[2][1] = 'T';
        dnaMatrix[2][2] = 'A';
        dnaMatrix[2][3] = 'T';
        dnaMatrix[2][4] = 'G';
        dnaMatrix[2][5] = 'T';
        dnaMatrix[3][0] = 'A';
        dnaMatrix[3][1] = 'G';
        dnaMatrix[3][2] = 'A';
        dnaMatrix[3][3] = 'A';
        dnaMatrix[3][4] = 'G';
        dnaMatrix[3][5] = 'G';
        dnaMatrix[4][0] = 'A';
        dnaMatrix[4][1] = 'C';
        dnaMatrix[4][2] = 'C';
        dnaMatrix[4][3] = 'C';
        dnaMatrix[4][4] = 'T';
        dnaMatrix[4][5] = 'A';
        dnaMatrix[5][0] = 'T';
        dnaMatrix[5][1] = 'C';
        dnaMatrix[5][2] = 'A';
        dnaMatrix[5][3] = 'C';
        dnaMatrix[5][4] = 'T';
        dnaMatrix[5][5] = 'G';

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @Test
    public void isMutantWhenDNAMatrixIs6x6AndHaveSequenceFourEqualLettersHorizontalThenMustReturnTrueTest() {
        char[][] dnaMatrix = new char[6][6];
        dnaMatrix[0][0] = 'C';
        dnaMatrix[0][1] = 'T';
        dnaMatrix[0][2] = 'G';
        dnaMatrix[0][3] = 'C';
        dnaMatrix[0][4] = 'A';
        dnaMatrix[0][5] = 'A';
        dnaMatrix[1][0] = 'C';
        dnaMatrix[1][1] = 'A';
        dnaMatrix[1][2] = 'G';
        dnaMatrix[1][3] = 'T';
        dnaMatrix[1][4] = 'G';
        dnaMatrix[1][5] = 'C';
        dnaMatrix[2][0] = 'T';
        dnaMatrix[2][1] = 'T';
        dnaMatrix[2][2] = 'A';
        dnaMatrix[2][3] = 'T';
        dnaMatrix[2][4] = 'G';
        dnaMatrix[2][5] = 'T';
        dnaMatrix[3][0] = 'A';
        dnaMatrix[3][1] = 'G';
        dnaMatrix[3][2] = 'A';
        dnaMatrix[3][3] = 'A';
        dnaMatrix[3][4] = 'G';
        dnaMatrix[3][5] = 'G';
        dnaMatrix[4][0] = 'C';
        dnaMatrix[4][1] = 'C';
        dnaMatrix[4][2] = 'C';
        dnaMatrix[4][3] = 'C';
        dnaMatrix[4][4] = 'T';
        dnaMatrix[4][5] = 'A';
        dnaMatrix[5][0] = 'T';
        dnaMatrix[5][1] = 'C';
        dnaMatrix[5][2] = 'A';
        dnaMatrix[5][3] = 'C';
        dnaMatrix[5][4] = 'T';
        dnaMatrix[5][5] = 'G';

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @Test
    public void isMutantWhenDNAMatrixIs6x6AndHave3SequencesFourEqualLettersThenMustReturnTrueTest() {
        char[][] dnaMatrix = new char[6][6];
        dnaMatrix[0][0] = 'A';
        dnaMatrix[0][1] = 'T';
        dnaMatrix[0][2] = 'G';
        dnaMatrix[0][3] = 'C';
        dnaMatrix[0][4] = 'G';
        dnaMatrix[0][5] = 'A';
        dnaMatrix[1][0] = 'C';
        dnaMatrix[1][1] = 'A';
        dnaMatrix[1][2] = 'G';
        dnaMatrix[1][3] = 'T';
        dnaMatrix[1][4] = 'G';
        dnaMatrix[1][5] = 'C';
        dnaMatrix[2][0] = 'T';
        dnaMatrix[2][1] = 'T';
        dnaMatrix[2][2] = 'A';
        dnaMatrix[2][3] = 'T';
        dnaMatrix[2][4] = 'G';
        dnaMatrix[2][5] = 'T';
        dnaMatrix[3][0] = 'A';
        dnaMatrix[3][1] = 'G';
        dnaMatrix[3][2] = 'A';
        dnaMatrix[3][3] = 'A';
        dnaMatrix[3][4] = 'G';
        dnaMatrix[3][5] = 'G';
        dnaMatrix[4][0] = 'C';
        dnaMatrix[4][1] = 'C';
        dnaMatrix[4][2] = 'C';
        dnaMatrix[4][3] = 'C';
        dnaMatrix[4][4] = 'T';
        dnaMatrix[4][5] = 'A';
        dnaMatrix[5][0] = 'T';
        dnaMatrix[5][1] = 'C';
        dnaMatrix[5][2] = 'A';
        dnaMatrix[5][3] = 'C';
        dnaMatrix[5][4] = 'T';
        dnaMatrix[5][5] = 'G';

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @AfterEach
    void tearDown() {
        this.mutantService = null;
    }
}