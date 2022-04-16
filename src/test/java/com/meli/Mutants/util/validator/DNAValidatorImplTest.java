package com.meli.Mutants.util.validator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.meli.Mutants.factory.DNAMatrixFactory;

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

        boolean result = dnaValidator.isDNANxN(dnaArray);

        Assertions.assertFalse(result);
    }

    @Test
    public void isDNANxNWhenDNAMatrixIsNotNxNThenMustReturnFalseTest() {
        String[] dnaArray = new String[4];
        dnaArray[0] = "ACTG";
        dnaArray[1] = "AAGT";
        dnaArray[2] = "GTA";
        dnaArray[3] = "GCTA";

        boolean result = dnaValidator.isDNANxN(dnaArray);

        Assertions.assertFalse(result);
    }

    @Test
    public void isDNANxNWhenDNAMatrixIsNxNThenMustReturnTrueTest() {
        String[] dnaArray = DNAMatrixFactory.getDnaArray6x6();

        boolean result = dnaValidator.isDNANxN(dnaArray);

        Assertions.assertTrue(result);
    }

    @Test
    public void isACGTWhenDNAMatrixHasLettersOtherThanACGTThenMustReturnFalseTest() {
        String[] dnaArray = new String[4];
        dnaArray[0] = "ACTG";
        dnaArray[1] = "AAPT";
        dnaArray[2] = "GTAC";
        dnaArray[3] = "GCTA";

        boolean result = dnaValidator.isACGT(dnaArray);

        Assertions.assertFalse(result);
    }

    @Test
    public void isACGTWhenDNAMatrixOnlyHasLettersACGTThenMustReturnTrueTest() {
        String[] dnaArray = DNAMatrixFactory.getDnaArray6x6();

        boolean result = dnaValidator.isACGT(dnaArray);

        Assertions.assertTrue(result);
    }

    @AfterEach
    void tearDown() {
        this.dnaValidator = null;
    }
}