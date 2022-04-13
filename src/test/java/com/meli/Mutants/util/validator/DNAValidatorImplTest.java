package com.meli.Mutants.util.validator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.meli.Mutants.factory.DNADtoFactory;
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
        String[] dnaArray = new String[1];
        dnaArray[0] = "A";
        DNADto dna = DNADtoFactory.unDNADto().conDNA(dnaArray).getInstance();

        boolean result = dnaValidator.isDNANxN(dna);

        Assertions.assertFalse(result);
    }

    @Test
    public void isDNANxNWhenDNAMatrixIsNotNxNThenMustReturnFalseTest() {
        String[] dnaArray = new String[4];
        dnaArray[0] = "ACTG";
        dnaArray[1] = "AAGT";
        dnaArray[2] = "GTA";
        dnaArray[3] = "GCTA";
        DNADto dna = DNADtoFactory.unDNADto().conDNA(dnaArray).getInstance();

        boolean result = dnaValidator.isDNANxN(dna);

        Assertions.assertFalse(result);
    }

    @Test
    public void isDNANxNWhenDNAMatrixIsNxNThenMustReturnTrueTest() {
        DNADto dna = DNADtoFactory.unDNADto().conDNA(DNAMatrixFactory.getDnaArray6x6()).getInstance();

        boolean result = dnaValidator.isDNANxN(dna);

        Assertions.assertTrue(result);
    }

    @Test
    public void isACGTWhenDNAMatrixHaveLettersOtherThanACGTThenMustReturnFalseTest() {
        String[] dnaArray = new String[4];
        dnaArray[0] = "ACTG";
        dnaArray[1] = "AAPT";
        dnaArray[2] = "GTAC";
        dnaArray[3] = "GCTA";
        DNADto dna = DNADtoFactory.unDNADto().conDNA(dnaArray).getInstance();

        boolean result = dnaValidator.isACGT(dna);

        Assertions.assertFalse(result);
    }

    @Test
    public void isACGTWhenDNAMatrixOnlyHaveLettersACGTThenMustReturnTrueTest() {
        DNADto dna = DNADtoFactory.unDNADto().conDNA(DNAMatrixFactory.getDnaArray6x6()).getInstance();

        boolean result = dnaValidator.isACGT(dna);

        Assertions.assertTrue(result);
    }

    @AfterEach
    void tearDown() {
        this.dnaValidator = null;
    }
}