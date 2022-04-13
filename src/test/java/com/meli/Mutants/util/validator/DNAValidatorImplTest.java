package com.meli.Mutants.util.validator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.meli.Mutants.factory.DNAMatrixFactory;
import com.meli.Mutants.model.DNADto;

public class DNAValidatorImplTest {

    private DNAValidatorImpl dnaValidator;

    @BeforeEach
    void setUp() {
        this.dnaValidator = Mockito.spy(new DNAValidatorImpl());
    }

    @Test
    public void isDNANxNWhenDNAMatrixHaveLess4RowsThenMustReturnFalseTest() {
        DNADto dna = new DNADto();
        String[] dnaArray = new String[1];
        dnaArray[0] = "A";
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
        dna.setDna(DNAMatrixFactory.getDnaArray6x6());

        boolean result = dnaValidator.isDNANxN(dna);

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

    @Test
    public void isACGTWhenDNAMatrixOnlyHaveLettersACGTThenMustReturnTrueTest() {
        DNADto dna = new DNADto();
        dna.setDna(DNAMatrixFactory.getDnaArray6x6());

        boolean result = dnaValidator.isACGT(dna);

        Assertions.assertTrue(result);
    }

    @AfterEach
    void tearDown() {
        this.dnaValidator = null;
    }
}