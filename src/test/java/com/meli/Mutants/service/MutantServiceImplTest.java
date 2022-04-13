package com.meli.Mutants.service;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import com.meli.Mutants.transformer.DNADtoTransformer;
import com.meli.Mutants.model.DNADto;
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
    public void whenIsNotDNACorrectThenMustReturnFalseTest() {
        DNADto dna = new DNADto();
        char[][] dnaMatrix = new char[0][];
        doReturn(false).when(mutantService).isDNACorrect(dna);

        boolean result = mutantService.isMutant(dna);

        Assertions.assertFalse(result);
        verify(mutantService).isDNACorrect(dna);
        verify(mutantService, Mockito.never()).isMutant(dnaMatrix);
    }

    @Test
    public void whenIsDNACorrectAndIsNotMutantThenMustReturnFalseTest() {
        DNADto dna = new DNADto();
        dna.setDna(DNAMatrixFactory.getDnaArray3x3());
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix3x3();
        DNADtoTransformer dnaDtoTransformer = Mockito.mock(DNADtoTransformer.class);
        doReturn(true).when(mutantService).isDNACorrect(dna);
        doReturn(dnaDtoTransformer).when(mutantService).getDNADtoTransformerInstance();
        doReturn(dnaMatrix).when(dnaDtoTransformer).transformerDNADtoToChar(dna);
        doReturn(false).when(mutantService).isMutant(dnaMatrix);

        boolean result = mutantService.isMutant(dna);

        Assertions.assertFalse(result);
        verify(mutantService).isDNACorrect(dna);
        verify(mutantService).getDNADtoTransformerInstance();
        verify(dnaDtoTransformer).transformerDNADtoToChar(dna);
        verify(mutantService).isMutant(dnaMatrix);
    }

    @Test
    public void whenIsDNACorrectAndIsMutantThenMustReturnTrueTest() {
        DNADto dna = new DNADto();
        dna.setDna(DNAMatrixFactory.getDnaArray3x3());
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix3x3();
        DNADtoTransformer dnaDtoTransformer = Mockito.mock(DNADtoTransformer.class);
        doReturn(true).when(mutantService).isDNACorrect(dna);
        doReturn(dnaDtoTransformer).when(mutantService).getDNADtoTransformerInstance();
        doReturn(dnaMatrix).when(dnaDtoTransformer).transformerDNADtoToChar(dna);
        doReturn(true).when(mutantService).isMutant(dnaMatrix);

        boolean result = mutantService.isMutant(dna);

        Assertions.assertTrue(result);
        verify(mutantService).isDNACorrect(dna);
        verify(mutantService).getDNADtoTransformerInstance();
        verify(dnaDtoTransformer).transformerDNADtoToChar(dna);
        verify(mutantService).isMutant(dnaMatrix);
    }

    @Test
    public void isDNACorrectWhenDNAArrayIsEmptyThenMustReturnFalseTest() {
        DNADto dna = new DNADto();
        DNAValidatorImpl dnaValidator = Mockito.mock(DNAValidatorImpl.class);

        boolean result = mutantService.isDNACorrect(dna);

        Assertions.assertFalse(result);
        verify(mutantService, Mockito.never()).getDNAValidatorImplInstance();
        verify(dnaValidator, Mockito.never()).isDNANxN(dna);
        verify(dnaValidator, Mockito.never()).isACGT(dna);
    }

    @Test
    public void isDNACorrectWhenIsNotDNANxNAndIsNotACGTThenMustReturnFalseTest() {
        DNADto dna = new DNADto();
        String[] dnaArray = new String[1];
        dnaArray[0] = "A";
        dna.setDna(dnaArray);
        DNAValidatorImpl dnaValidator = Mockito.mock(DNAValidatorImpl.class);
        doReturn(dnaValidator).when(mutantService).getDNAValidatorImplInstance();
        doReturn(false).when(dnaValidator).isDNANxN(dna);
        doReturn(false).when(dnaValidator).isACGT(dna);

        boolean result = mutantService.isDNACorrect(dna);

        Assertions.assertFalse(result);
        verify(mutantService).getDNAValidatorImplInstance();
        verify(dnaValidator).isDNANxN(dna);
        verify(dnaValidator, Mockito.never()).isACGT(dna);
    }

    @Test
    public void isDNACorrectWhenIsNotDNANxNAndIsACGTThenMustReturnFalseTest() {
        DNADto dna = new DNADto();
        String[] dnaArray = new String[1];
        dnaArray[0] = "A";
        dna.setDna(dnaArray);
        DNAValidatorImpl dnaValidator = Mockito.mock(DNAValidatorImpl.class);
        doReturn(dnaValidator).when(mutantService).getDNAValidatorImplInstance();
        doReturn(false).when(dnaValidator).isDNANxN(dna);
        doReturn(true).when(dnaValidator).isACGT(dna);

        boolean result = mutantService.isDNACorrect(dna);

        Assertions.assertFalse(result);
        verify(mutantService).getDNAValidatorImplInstance();
        verify(dnaValidator).isDNANxN(dna);
        verify(dnaValidator, Mockito.never()).isACGT(dna);
    }

    @Test
    public void isDNACorrectWhenIsDNANxNAndIsNotACGTThenMustReturnFalseTest() {
        DNADto dna = new DNADto();
        String[] dnaArray = new String[1];
        dnaArray[0] = "A";
        dna.setDna(dnaArray);
        DNAValidatorImpl dnaValidator = Mockito.mock(DNAValidatorImpl.class);
        doReturn(dnaValidator).when(mutantService).getDNAValidatorImplInstance();
        doReturn(true).when(dnaValidator).isDNANxN(dna);
        doReturn(false).when(dnaValidator).isACGT(dna);

        boolean result = mutantService.isDNACorrect(dna);

        Assertions.assertFalse(result);
        verify(mutantService).getDNAValidatorImplInstance();
        verify(dnaValidator).isDNANxN(dna);
        verify(dnaValidator).isACGT(dna);
    }

    @Test
    public void isDNACorrectWhenIsDNANxNAndIsACGTThenMustReturnTrueTest() {
        DNADto dna = new DNADto();
        String[] dnaArray = new String[1];
        dnaArray[0] = "A";
        dna.setDna(dnaArray);
        DNAValidatorImpl dnaValidator = Mockito.mock(DNAValidatorImpl.class);
        doReturn(dnaValidator).when(mutantService).getDNAValidatorImplInstance();
        doReturn(true).when(dnaValidator).isDNANxN(dna);
        doReturn(true).when(dnaValidator).isACGT(dna);

        boolean result = mutantService.isDNACorrect(dna);

        Assertions.assertTrue(result);
        verify(mutantService).getDNAValidatorImplInstance();
        verify(dnaValidator).isDNANxN(dna);
        verify(dnaValidator).isACGT(dna);
    }

    @Test
    public void isMutantWhenDNAMatrixHaveNoSequencesThenMustReturnFalseTest() {
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
    public void isMutantWhenDNAMatrixIs4x4AndHaveObliqueSequenceFourEqualLettersThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithObliqueSequenceFourEqualLetters();
        doReturn(true).when(mutantService).validateObliqueSequence(dnaMatrix);

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertTrue(result);
        verify(mutantService).validateObliqueSequence(dnaMatrix);
    }

    @Test
    public void isMutantWhenDNAMatrixIs4x4AndHaveSequenceFourEqualLettersVerticalThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithSequenceFourEqualLettersVertical();
        doReturn(true).when(mutantService).validateSequenceVertical(dnaMatrix);

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertTrue(result);
        verify(mutantService).validateSequenceVertical(dnaMatrix);
    }

    @Test
    public void isMutantWhenDNAMatrixIs4x4AndHaveSequenceFourEqualLettersHorizontalThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithSequenceFourEqualLettersHorizontal();
        doReturn(true).when(mutantService).validateSequenceHorizontal(dnaMatrix);

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertTrue(result);
        verify(mutantService).validateSequenceHorizontal(dnaMatrix);
    }

    @Test
    public void isMutantWhenDNAMatrixIs4x4AndHaveObliqueInverseSequenceFourEqualLettersThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithInverseObliqueSequenceFourEqualLetters();
        doReturn(true).when(mutantService).validateInverseObliqueSequence(dnaMatrix);

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertTrue(result);
        verify(mutantService).validateInverseObliqueSequence(dnaMatrix);
    }

    @Test
    public void isMutantWhenDNAMatrixIs6x6AndHave4SequencesFourEqualLettersThenMustReturnTrueTest() {
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
    public void validateObliqueSequenceWhenDNAMatrixIs4x4AndHaveNotObliqueSequenceFourEqualLettersThenMustReturnFalseTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithoutNoneSequenceOfFourEqualLetters();

        boolean result = mutantService.validateObliqueSequence(dnaMatrix);

        Assertions.assertFalse(result);
    }

    @Test
    public void validateObliqueSequenceWhenDNAMatrixIs4x4AndHaveObliqueSequenceFourEqualLettersThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithObliqueSequenceFourEqualLetters();

        boolean result = mutantService.validateObliqueSequence(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @Test
    public void validateObliqueSequenceWhenDNAMatrixIs6x6AndHaveObliqueSequenceFourEqualLettersThenMustReturnTrueTest() {
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
    public void validateSequenceVerticalWhenDNAMatrixIs4x4AndHaveNotObliqueSequenceFourEqualLettersThenMustReturnFalseTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithoutNoneSequenceOfFourEqualLetters();

        boolean result = mutantService.validateSequenceVertical(dnaMatrix);

        Assertions.assertFalse(result);
    }

    @Test
    public void validateSequenceVerticalWhenDNAMatrixIs4x4AndHaveSequenceFourEqualLettersVerticalThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithSequenceFourEqualLettersVertical();

        boolean result = mutantService.validateSequenceVertical(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @Test
    public void validateSequenceVerticalWhenDNAMatrixIs6x6AndHaveSequenceFourEqualLettersVerticalThenMustReturnTrueTest() {
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
    public void validateSequenceHorizontalWhenDNAMatrixIs4x4AndHaveNotObliqueSequenceFourEqualLettersThenMustReturnFalseTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithoutNoneSequenceOfFourEqualLetters();

        boolean result = mutantService.validateSequenceHorizontal(dnaMatrix);

        Assertions.assertFalse(result);
    }

    @Test
    public void validateSequenceHorizontalWhenDNAMatrixIs4x4AndHaveSequenceFourEqualLettersHorizontalThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithSequenceFourEqualLettersHorizontal();

        boolean result = mutantService.validateSequenceHorizontal(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @Test
    public void validateSequenceHorizontalWhenDNAMatrixIs6x6AndHaveSequenceFourEqualLettersHorizontalThenMustReturnTrueTest() {
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
    public void validateInverseObliqueSequenceWhenDNAMatrixIs4x4AndHaveNotObliqueSequenceFourEqualLettersThenMustReturnFalseTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithoutNoneSequenceOfFourEqualLetters();

        boolean result = mutantService.validateInverseObliqueSequence(dnaMatrix);

        Assertions.assertFalse(result);
    }

    @Test
    public void validateInverseObliqueSequenceWhenDNAMatrixIs4x4AndHaveObliqueInverseSequenceFourEqualLettersThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithInverseObliqueSequenceFourEqualLetters();

        boolean result = mutantService.validateInverseObliqueSequence(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @Test
    public void validateInverseObliqueSequenceWhenDNAMatrixIs6x6AndHaveObliqueInverseSequenceFourEqualLettersThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix6x6WithInverseObliqueSequenceFourEqualLetters();

        boolean result = mutantService.validateInverseObliqueSequence(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @AfterEach
    void tearDown() {
        this.mutantService = null;
    }
}