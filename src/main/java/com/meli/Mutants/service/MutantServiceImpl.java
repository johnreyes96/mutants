package com.meli.Mutants.service;

import org.springframework.stereotype.Service;

import com.meli.Mutants.transformer.DNATransformer;
import com.meli.Mutants.util.validator.DNAValidatorImpl;
import com.meli.Mutants.util.StringUtils;

@Service
public class MutantServiceImpl implements IMutantService {

    @Override
    public boolean isMutant(String[] dna) {
        if (StringUtils.isEmpty(dna)) return false;
        if (!isDNACorrect(dna)) return false;

        return isMutant(getDNATransformerInstance().transformerStringArrayToCharMatrix(dna));
    }

    protected boolean isDNACorrect(String[] dna) {
        DNAValidatorImpl validator = getDNAValidatorImplInstance();
        return validator.isDNANxN(dna) && validator.isACGT(dna);
    }

    /**
     * Checks if a human is a mutant.
     * @param dnaMatrix matrix {@code char[][]} NxN elements with characters ACGT to check
     * @return {@code true} if there is more than one sequence of four identical letters,
     * obliquely, horizontally, or vertically
     */
    protected boolean isMutant(char[][] dnaMatrix) {
        return validateObliqueSequence(dnaMatrix) || validateSequenceVertical(dnaMatrix)
                || validateSequenceHorizontal(dnaMatrix) || validateInverseObliqueSequence(dnaMatrix);
    }

    /**
     * Checks oblique sequence of four identical letters.
     * <p><pre class="code">
     * A * * *
     * * A * *
     * * * A *
     * * * * A
     * </pre>
     * @param dnaMatrix matrix {@code char[][]} NxN elements with characters ACGT to check
     * @return {@code true} if oblique sequence of four identical letters
     */
    protected boolean validateObliqueSequence(char[][] dnaMatrix) {
        for (int indexRow = 0; indexRow < dnaMatrix.length - 3; indexRow++) {
            for (int indexColumn = 0; indexColumn < dnaMatrix[indexRow].length - 3; indexColumn++) {
                if (dnaMatrix[indexRow][indexColumn] == dnaMatrix[indexRow + 1][indexColumn + 1]
                        && dnaMatrix[indexRow][indexColumn] == dnaMatrix[indexRow + 2][indexColumn + 2]
                        && dnaMatrix[indexRow][indexColumn] == dnaMatrix[indexRow + 3][indexColumn + 3]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks sequence of four identical letters vertical.
     * <p><pre class="code">
     * * * A *
     * * * A *
     * * * A *
     * * * A *
     * </pre>
     * @param dnaMatrix matrix {@code char[][]} NxN elements with characters ACGT to check
     * @return {@code true} if sequence of four identical letters vertical
     */
    protected boolean validateSequenceVertical(char[][] dnaMatrix) {
        for (int indexRow = 0; indexRow < dnaMatrix.length - 3; indexRow++) {
            for (int indexColumn = 0; indexColumn < dnaMatrix[indexRow].length; indexColumn++) {
                if (dnaMatrix[indexRow][indexColumn] == dnaMatrix[indexRow + 1][indexColumn]
                        && dnaMatrix[indexRow][indexColumn] == dnaMatrix[indexRow + 2][indexColumn]
                        && dnaMatrix[indexRow][indexColumn] == dnaMatrix[indexRow + 3][indexColumn]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks sequence of four identical letters horizontal.
     * <p><pre class="code">
     * * * * *
     * * * * *
     * A A A A
     * * * * *
     * </pre>
     * @param dnaMatrix matrix {@code char[][]} NxN elements with characters ACGT to check
     * @return {@code true} if sequence of four identical letters horizontal
     */
    protected boolean validateSequenceHorizontal(char[][] dnaMatrix) {
        for (char[] matrix : dnaMatrix) {
            for (int indexColumn = 0; indexColumn < matrix.length - 3; indexColumn++) {
                if (matrix[indexColumn] == matrix[indexColumn + 1]
                        && matrix[indexColumn] == matrix[indexColumn + 2]
                        && matrix[indexColumn] == matrix[indexColumn + 3]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks inverse oblique sequence of four identical letters.
     * <p><pre class="code">
     * * * * A
     * * * A *
     * * A * *
     * A * * *
     * </pre>
     * @param dnaMatrix matrix {@code char[][]} NxN elements with characters ACGT to check
     * @return {@code true} if inverse oblique sequence of four identical letters
     */
    protected boolean validateInverseObliqueSequence(char[][] dnaMatrix) {
        for (int indexRow = 0; indexRow < dnaMatrix.length - 3; indexRow++) {
            for (int indexColumn = dnaMatrix[indexRow].length - 1; indexColumn >= dnaMatrix[indexRow].length - 3; indexColumn--) {
                if (dnaMatrix[indexRow][indexColumn] == dnaMatrix[indexRow + 1][indexColumn - 1]
                        && dnaMatrix[indexRow][indexColumn] == dnaMatrix[indexRow + 2][indexColumn - 2]
                        && dnaMatrix[indexRow][indexColumn] == dnaMatrix[indexRow + 3][indexColumn - 3]) {
                    return true;
                }
            }
        }
        return false;
    }

    public DNATransformer getDNATransformerInstance() {
        return new DNATransformer();
    }

    protected DNAValidatorImpl getDNAValidatorImplInstance() {
        return new DNAValidatorImpl();
    }
}