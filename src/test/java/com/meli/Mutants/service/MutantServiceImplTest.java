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
    public void isMutantWhenDNAMatrixIsEmptyThenMustReturnFalseTest() {
        char[][] dnaMatrix = new char[0][];

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertFalse(result);
    }

    @Test
    public void isMutantWhenDNAMatrixIsSmallerOf4x4ThenMustReturnFalseTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix3x3();

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertFalse(result);
    }

    @Test
    public void isMutantWhenDNAMatrixIs4x4AndHaveObliqueSequenceFourEqualLettersThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithObliqueSequenceFourEqualLetters();

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @Test
    public void isMutantWhenDNAMatrixIs4x4AndHaveOblique2SequenceFourEqualLettersThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithInverseObliqueSequenceFourEqualLetters();

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @Test
    public void isMutantWhenDNAMatrixIs4x4AndHaveSequenceFourEqualLettersVerticalThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithSequenceFourEqualLettersVertical();

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @Test
    public void isMutantWhenDNAMatrixIs4x4AndHaveSequenceFourEqualLettersHorizontalThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix4x4WithSequenceFourEqualLettersHorizontal();

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @Test
    public void isMutantWhenDNAMatrixIs6x6AndHaveObliqueSequenceFourEqualLettersThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix6x6WithObliqueSequenceFourEqualLetters();

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @Test
    public void isMutantWhenDNAMatrixIs6x6AndHaveOblique2SequenceFourEqualLettersThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix6x6WithInverseObliqueSequenceFourEqualLetters();

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @Test
    public void isMutantWhenDNAMatrixIs6x6AndHaveSequenceFourEqualLettersVerticalThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix6x6WithSequenceFourEqualLettersVertical();

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @Test
    public void isMutantWhenDNAMatrixIs6x6AndHaveSequenceFourEqualLettersHorizontalThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix6x6WithSequenceFourEqualLettersHorizontal();

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @Test
    public void isMutantWhenDNAMatrixIs6x6AndHave3SequencesFourEqualLettersThenMustReturnTrueTest() {
        char[][] dnaMatrix = DNAMatrixFactory.getDnaMatrix6x6WithSequencesFourEqualLettersVerticalHorizontalAndOblique();

        boolean result = mutantService.isMutant(dnaMatrix);

        Assertions.assertTrue(result);
    }

    @AfterEach
    void tearDown() {
        this.mutantService = null;
    }
}