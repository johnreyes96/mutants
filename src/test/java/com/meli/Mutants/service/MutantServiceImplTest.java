package com.meli.Mutants.service;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import com.meli.Mutants.transformer.DNATransformer;
import com.meli.Mutants.factory.DNAMatrixFactory;
import com.meli.Mutants.util.validator.DNAValidatorImpl;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class MutantServiceImplTest {

    private MutantServiceImpl mutantService;

    @BeforeEach
    void setUp() {
        this.mutantService = Mockito.spy(new MutantServiceImpl());
    }

    @Test
    public void whenDnaArrayIsEmptyThenMustReturnFalseTest() {
        String[] dnaArray = new String[0];

        boolean result = mutantService.isMutant(dnaArray);

        Assertions.assertFalse(result);
        verify(mutantService, Mockito.never()).isDNACorrect(Mockito.any());
    }

    @Test
    public void whenArrayIsNotEmptyAndIsNotDNACorrectThenMustReturnFalseTest() {
        String[] dnaArray = new String[1];
        dnaArray[0] = "A";
        doReturn(false).when(mutantService).isDNACorrect(dnaArray);

        boolean result = mutantService.isMutant(dnaArray);

        Assertions.assertFalse(result);
        verify(mutantService).isDNACorrect(dnaArray);
    }

    @Test
    public void whenArrayIsNotEmptyAndIsDNACorrectAndIsNotMutantThenMustReturnFalseTest() {
        String[] dnaArray = DNAMatrixFactory.getDnaArray3x3();
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix3x3();
        DNATransformer dnaDtoTransformer = Mockito.mock(DNATransformer.class);
        doReturn(true).when(mutantService).isDNACorrect(dnaArray);
        doReturn(dnaDtoTransformer).when(mutantService).getDNATransformerInstance();
        doReturn(dnaMatrix).when(dnaDtoTransformer).transformerStringArrayToCharMatrix(dnaArray);
        doReturn(false).when(mutantService).isMutant(dnaMatrix);

        boolean result = mutantService.isMutant(dnaArray);

        Assertions.assertFalse(result);
        verify(mutantService).isDNACorrect(dnaArray);
        verify(mutantService).getDNATransformerInstance();
        verify(dnaDtoTransformer).transformerStringArrayToCharMatrix(dnaArray);
        verify(mutantService).isMutant(dnaMatrix);
    }

    @Test
    public void whenArrayIsNotEmptyAndIsDNACorrectAndIsMutantThenMustReturnTrueTest() {
        String[] dnaArray = DNAMatrixFactory.getDnaArray3x3();
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix3x3();
        DNATransformer dnaDtoTransformer = Mockito.mock(DNATransformer.class);
        doReturn(true).when(mutantService).isDNACorrect(dnaArray);
        doReturn(dnaDtoTransformer).when(mutantService).getDNATransformerInstance();
        doReturn(dnaMatrix).when(dnaDtoTransformer).transformerStringArrayToCharMatrix(dnaArray);
        doReturn(true).when(mutantService).isMutant(dnaMatrix);

        boolean result = mutantService.isMutant(dnaArray);

        Assertions.assertTrue(result);
        verify(mutantService).isDNACorrect(dnaArray);
        verify(mutantService).getDNATransformerInstance();
        verify(dnaDtoTransformer).transformerStringArrayToCharMatrix(dnaArray);
        verify(mutantService).isMutant(dnaMatrix);
    }

    @Test
    public void isDNACorrectWhenIsNotDNANxNAndIsNotACGTThenMustReturnFalseTest() {
        String[] dnaArray = new String[1];
        dnaArray[0] = "A";
        DNAValidatorImpl dnaValidator = Mockito.mock(DNAValidatorImpl.class);
        doReturn(dnaValidator).when(mutantService).getDNAValidatorImplInstance();
        doReturn(false).when(dnaValidator).isDNANxN(dnaArray);
        doReturn(false).when(dnaValidator).isACGT(dnaArray);

        boolean result = mutantService.isDNACorrect(dnaArray);

        Assertions.assertFalse(result);
        verify(mutantService).getDNAValidatorImplInstance();
        verify(dnaValidator).isDNANxN(dnaArray);
        verify(dnaValidator, Mockito.never()).isACGT(dnaArray);
    }

    @Test
    public void isDNACorrectWhenIsNotDNANxNAndIsACGTThenMustReturnFalseTest() {
        String[] dnaArray = new String[1];
        dnaArray[0] = "A";
        DNAValidatorImpl dnaValidator = Mockito.mock(DNAValidatorImpl.class);
        doReturn(dnaValidator).when(mutantService).getDNAValidatorImplInstance();
        doReturn(false).when(dnaValidator).isDNANxN(dnaArray);
        doReturn(true).when(dnaValidator).isACGT(dnaArray);

        boolean result = mutantService.isDNACorrect(dnaArray);

        Assertions.assertFalse(result);
        verify(mutantService).getDNAValidatorImplInstance();
        verify(dnaValidator).isDNANxN(dnaArray);
        verify(dnaValidator, Mockito.never()).isACGT(dnaArray);
    }

    @Test
    public void isDNACorrectWhenIsDNANxNAndIsNotACGTThenMustReturnFalseTest() {
        String[] dnaArray = new String[1];
        dnaArray[0] = "A";
        DNAValidatorImpl dnaValidator = Mockito.mock(DNAValidatorImpl.class);
        doReturn(dnaValidator).when(mutantService).getDNAValidatorImplInstance();
        doReturn(true).when(dnaValidator).isDNANxN(dnaArray);
        doReturn(false).when(dnaValidator).isACGT(dnaArray);

        boolean result = mutantService.isDNACorrect(dnaArray);

        Assertions.assertFalse(result);
        verify(mutantService).getDNAValidatorImplInstance();
        verify(dnaValidator).isDNANxN(dnaArray);
        verify(dnaValidator).isACGT(dnaArray);
    }

    @Test
    public void isDNACorrectWhenIsDNANxNAndIsACGTThenMustReturnTrueTest() {
        String[] dnaArray = new String[1];
        dnaArray[0] = "A";
        DNAValidatorImpl dnaValidator = Mockito.mock(DNAValidatorImpl.class);
        doReturn(dnaValidator).when(mutantService).getDNAValidatorImplInstance();
        doReturn(true).when(dnaValidator).isDNANxN(dnaArray);
        doReturn(true).when(dnaValidator).isACGT(dnaArray);

        boolean result = mutantService.isDNACorrect(dnaArray);

        Assertions.assertTrue(result);
        verify(mutantService).getDNAValidatorImplInstance();
        verify(dnaValidator).isDNANxN(dnaArray);
        verify(dnaValidator).isACGT(dnaArray);
    }

    @Test
    public void isMutantWhenDNAMatrixHasNoSequencesThenMustReturnFalseTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithoutNoneSequenceOfFourEqualLetters();
        doReturn(false).when(mutantService).validateObliqueSequence(dnaMatrix);
        doReturn(false).when(mutantService).validateSequenceVertical(dnaMatrix);
        doReturn(false).when(mutantService).validateSequenceHorizontal(dnaMatrix);
        doReturn(false).when(mutantService).validateInverseObliqueSequence(dnaMatrix);

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertFalse(result);
        verify(mutantService).validateObliqueSequence(dnaMatrix);
        verify(mutantService).validateSequenceVertical(dnaMatrix);
        verify(mutantService).validateSequenceHorizontal(dnaMatrix);
        verify(mutantService).validateInverseObliqueSequence(dnaMatrix);
    }

    @Test
    public void isMutantWhenDNAMatrixIs4x4AndHasObliqueSequenceFourEqualLettersThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithObliqueSequenceFourEqualLetters();
        doReturn(true).when(mutantService).validateObliqueSequence(dnaMatrix);

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertTrue(result);
        verify(mutantService).validateObliqueSequence(dnaMatrix);
    }

    @Test
    public void isMutantWhenDNAMatrixIs4x4AndHasSequenceFourEqualLettersVerticalThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithSequenceFourEqualLettersVertical();
        doReturn(true).when(mutantService).validateSequenceVertical(dnaMatrix);

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertTrue(result);
        verify(mutantService).validateSequenceVertical(dnaMatrix);
    }

    @Test
    public void isMutantWhenDNAMatrixIs4x4AndHasSequenceFourEqualLettersHorizontalThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithSequenceFourEqualLettersHorizontal();
        doReturn(true).when(mutantService).validateSequenceHorizontal(dnaMatrix);

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertTrue(result);
        verify(mutantService).validateSequenceHorizontal(dnaMatrix);
    }

    @Test
    public void isMutantWhenDNAMatrixIs4x4AndHasObliqueInverseSequenceFourEqualLettersThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithInverseObliqueSequenceFourEqualLetters();
        doReturn(true).when(mutantService).validateInverseObliqueSequence(dnaMatrix);

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertTrue(result);
        verify(mutantService).validateInverseObliqueSequence(dnaMatrix);
    }

    @Test
    public void isMutantWhenDNAMatrixIs6x6AndHas4SequencesFourEqualLettersThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix6x6WithSequencesFourEqualLettersVerticalHorizontalAndOblique();
        doReturn(true).when(mutantService).validateObliqueSequence(dnaMatrix);
        doReturn(true).when(mutantService).validateSequenceVertical(dnaMatrix);
        doReturn(true).when(mutantService).validateSequenceHorizontal(dnaMatrix);
        doReturn(true).when(mutantService).validateInverseObliqueSequence(dnaMatrix);

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertTrue(result);
        verify(mutantService).validateObliqueSequence(dnaMatrix);
    }

    @Test
    public void validateObliqueSequenceWhenDNAMatrixIsEmptyThenMustReturnFalseTest() {
        char[][] dnaMatrix = new char[0][];

        boolean result = mutantService.validateObliqueSequence(dnaMatrix);

        Assertions.assertFalse(result);
    }

    @Test
    public void validateObliqueSequenceWhenDNAMatrixIs4x4AndHasNotObliqueSequenceFourEqualLettersThenMustReturnFalseTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithoutNoneSequenceOfFourEqualLetters();

        boolean result = mutantService.validateObliqueSequence(dnaMatrix);

        Assertions.assertFalse(result);
    }

    @Test
    public void validateObliqueSequenceWhenDNAMatrixIs4x4AndHasObliqueSequenceFourEqualLettersThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithObliqueSequenceFourEqualLetters();

        boolean result = mutantService.validateObliqueSequence(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @Test
    public void validateObliqueSequenceWhenDNAMatrixIs6x6AndHasObliqueSequenceFourEqualLettersThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix6x6WithObliqueSequenceFourEqualLetters();

        boolean result = mutantService.validateObliqueSequence(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @Test
    public void validateSequenceVerticalWhenDNAMatrixIsEmptyThenMustReturnFalseTest() {
        char[][] dnaMatrix = new char[0][];

        boolean result = mutantService.validateSequenceVertical(dnaMatrix);

        Assertions.assertFalse(result);
    }

    @Test
    public void validateSequenceVerticalWhenDNAMatrixIs4x4AndHasNotObliqueSequenceFourEqualLettersThenMustReturnFalseTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithoutNoneSequenceOfFourEqualLetters();

        boolean result = mutantService.validateSequenceVertical(dnaMatrix);

        Assertions.assertFalse(result);
    }

    @Test
    public void validateSequenceVerticalWhenDNAMatrixIs4x4AndHasSequenceFourEqualLettersVerticalThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithSequenceFourEqualLettersVertical();

        boolean result = mutantService.validateSequenceVertical(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @Test
    public void validateSequenceVerticalWhenDNAMatrixIs6x6AndHasSequenceFourEqualLettersVerticalThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix6x6WithSequenceFourEqualLettersVertical();

        boolean result = mutantService.validateSequenceVertical(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @Test
    public void validateSequenceHorizontalWhenDNAMatrixIsEmptyThenMustReturnFalseTest() {
        char[][] dnaMatrix = new char[0][];

        boolean result = mutantService.validateSequenceHorizontal(dnaMatrix);

        Assertions.assertFalse(result);
    }

    @Test
    public void validateSequenceHorizontalWhenDNAMatrixIs4x4AndHasNotObliqueSequenceFourEqualLettersThenMustReturnFalseTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithoutNoneSequenceOfFourEqualLetters();

        boolean result = mutantService.validateSequenceHorizontal(dnaMatrix);

        Assertions.assertFalse(result);
    }

    @Test
    public void validateSequenceHorizontalWhenDNAMatrixIs4x4AndHasSequenceFourEqualLettersHorizontalThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithSequenceFourEqualLettersHorizontal();

        boolean result = mutantService.validateSequenceHorizontal(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @Test
    public void validateSequenceHorizontalWhenDNAMatrixIs6x6AndHasSequenceFourEqualLettersHorizontalThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix6x6WithSequenceFourEqualLettersHorizontal();

        boolean result = mutantService.validateSequenceHorizontal(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @Test
    public void validateInverseObliqueSequenceWhenDNAMatrixIsEmptyThenMustReturnFalseTest() {
        char[][] dnaMatrix = new char[0][];

        boolean result = mutantService.validateInverseObliqueSequence(dnaMatrix);

        Assertions.assertFalse(result);
    }

    @Test
    public void validateInverseObliqueSequenceWhenDNAMatrixIs4x4AndHasNotObliqueSequenceFourEqualLettersThenMustReturnFalseTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithoutNoneSequenceOfFourEqualLetters();

        boolean result = mutantService.validateInverseObliqueSequence(dnaMatrix);

        Assertions.assertFalse(result);
    }

    @Test
    public void validateInverseObliqueSequenceWhenDNAMatrixIs4x4AndHasObliqueInverseSequenceFourEqualLettersThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithInverseObliqueSequenceFourEqualLetters();

        boolean result = mutantService.validateInverseObliqueSequence(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @Test
    public void validateInverseObliqueSequenceWhenDNAMatrixIs6x6AndHasObliqueInverseSequenceFourEqualLettersThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix6x6WithInverseObliqueSequenceFourEqualLetters();

        boolean result = mutantService.validateInverseObliqueSequence(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @AfterEach
    void tearDown() {
        this.mutantService = null;
    }
}