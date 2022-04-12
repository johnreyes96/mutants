package com.meli.Mutants.util.validator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.meli.Mutants.model.DNADto;

public class DNAValidatorImplTest {

    private DNAValidatorImpl dnaValidator;

    @BeforeEach
    void setUp() {
        this.dnaValidator = Mockito.spy(new DNAValidatorImpl());
    }

    @Test
    public void isDNANxNWhenDNAMatrixIsEmptyThenMustReturnFalseTest() {
        DNADto dna = new DNADto();

        boolean result = dnaValidator.isDNANxN(dna);

        Assertions.assertFalse(result);
    }

    @Test
    public void isDNANxNWhenDNAMatrixHaveLess4RowsThenMustReturnFalseTest() {
        DNADto dna = new DNADto();
        String[] dnaArray = new String[0];
        dna.setDna(dnaArray);

        boolean result = dnaValidator.isDNANxN(dna);

        Assertions.assertFalse(result);
    }

    @Test
    public void isDNANxNWhenDNAMatrixIsNotNxNThenMustReturnFalseTest() {
        DNADto dna = new DNADto();
        String[] dnaArray = new String[4];
        dnaArray[0] = "ACTG";
        dnaArray[1] = "AAGT";
        dnaArray[2] = "GTA";
        dnaArray[3] = "GCTA";
        dna.setDna(dnaArray);

        boolean result = dnaValidator.isDNANxN(dna);

        Assertions.assertFalse(result);
    }

    @Test
    public void isDNANxNWhenDNAMatrixIsNxNThenMustReturnTrueTest() {
        DNADto dna = new DNADto();
        String[] dnaArray = new String[6];
        dnaArray[0] = "ATGCGA";
        dnaArray[1] = "CAGTGC";
        dnaArray[2] = "TTATGT";
        dnaArray[3] = "AGAAGG";
        dnaArray[4] = "CCCCTA";
        dnaArray[5] = "TCACTG";
        dna.setDna(dnaArray);

        boolean result = dnaValidator.isDNANxN(dna);

        Assertions.assertTrue(result);
    }

    @Test
    public void isACGTWhenDNAMatrixIsNullThenMustReturnFalseTest() {
        DNADto dna = new DNADto();

        boolean result = dnaValidator.isACGT(dna);

        Assertions.assertFalse(result);
    }

    @Test
    public void isACGTWhenDNAMatrixIsEmptyThenMustReturnFalseTest() {
        DNADto dna = new DNADto();
        String[] dnaArray = new String[0];
        dna.setDna(dnaArray);

        boolean result = dnaValidator.isACGT(dna);

        Assertions.assertFalse(result);
    }

    @Test
    public void isACGTWhenDNAMatrixOnlyHaveLettersACGTThenMustReturnTrueTest() {
        DNADto dna = new DNADto();
        String[] dnaArray = new String[6];
        dnaArray[0] = "ATGCGA";
        dnaArray[1] = "CAGTGC";
        dnaArray[2] = "TTATGT";
        dnaArray[3] = "AGAAGG";
        dnaArray[4] = "CCCCTA";
        dnaArray[5] = "TCACTG";
        dna.setDna(dnaArray);

        boolean result = dnaValidator.isACGT(dna);

        Assertions.assertTrue(result);
    }

    @Test
    public void isACGTWhenDNAMatrixHaveLettersOtherThanACGTThenMustReturnFalseTest() {
        DNADto dna = new DNADto();
        String[] dnaArray = new String[4];
        dnaArray[0] = "ACTG";
        dnaArray[1] = "AAPT";
        dnaArray[2] = "GTAC";
        dnaArray[3] = "GCTA";
        dna.setDna(dnaArray);

        boolean result = dnaValidator.isACGT(dna);

        Assertions.assertFalse(result);
    }

    @AfterEach
    void tearDown() {
        this.dnaValidator = null;
    }
}