package com.meli.Mutants.factory;

public class DNAMatrixFactory {

    public static String[] getDnaArray6x6() {
        String[] dnaArray = new String[6];
        dnaArray[0] = "ATGCGA";
        dnaArray[1] = "CAGTGC";
        dnaArray[2] = "TTATGT";
        dnaArray[3] = "AGAAGG";
        dnaArray[4] = "CCCCTA";
        dnaArray[5] = "TCACTG";
        return dnaArray;
    }

    public static String[] getDnaArray3x3() {
        String[] dnaArray = new String[3];
        dnaArray[0] = "ATG";
        dnaArray[1] = "CAG";
        dnaArray[2] = "TTA";
        return dnaArray;
    }

    public static char[][] getDnaMatrix3x3() {
        char[][] dnaMatrix3x3 = new char[3][3];
        dnaMatrix3x3[0][0] = 'A';
        dnaMatrix3x3[0][1] = 'T';
        dnaMatrix3x3[0][2] = 'G';
        dnaMatrix3x3[1][0] = 'C';
        dnaMatrix3x3[1][1] = 'A';
        dnaMatrix3x3[1][2] = 'G';
        dnaMatrix3x3[2][0] = 'T';
        dnaMatrix3x3[2][1] = 'T';
        dnaMatrix3x3[2][2] = 'A';
        return dnaMatrix3x3;
    }

    public static char[][] getDnaMatrix4x4WithObliqueSequenceFourEqualLetters() {
        char[][] dnaMatrix4x4 = new char[4][4];
        dnaMatrix4x4[0][0] = 'A';
        dnaMatrix4x4[0][1] = 'T';
        dnaMatrix4x4[0][2] = 'G';
        dnaMatrix4x4[0][3] = 'C';
        dnaMatrix4x4[1][0] = 'C';
        dnaMatrix4x4[1][1] = 'A';
        dnaMatrix4x4[1][2] = 'G';
        dnaMatrix4x4[1][3] = 'T';
        dnaMatrix4x4[2][0] = 'T';
        dnaMatrix4x4[2][1] = 'T';
        dnaMatrix4x4[2][2] = 'A';
        dnaMatrix4x4[2][3] = 'T';
        dnaMatrix4x4[3][0] = 'A';
        dnaMatrix4x4[3][1] = 'G';
        dnaMatrix4x4[3][2] = 'A';
        dnaMatrix4x4[3][3] = 'A';
        return dnaMatrix4x4;
    }

    public static char[][] getDnaMatrix4x4WithInverseObliqueSequenceFourEqualLetters() {
        char[][] dnaMatrix4x4 = new char[4][4];
        dnaMatrix4x4[0][0] = 'C';
        dnaMatrix4x4[0][1] = 'G';
        dnaMatrix4x4[0][2] = 'T';
        dnaMatrix4x4[0][3] = 'A';
        dnaMatrix4x4[1][0] = 'T';
        dnaMatrix4x4[1][1] = 'G';
        dnaMatrix4x4[1][2] = 'A';
        dnaMatrix4x4[1][3] = 'C';
        dnaMatrix4x4[2][0] = 'T';
        dnaMatrix4x4[2][1] = 'A';
        dnaMatrix4x4[2][2] = 'T';
        dnaMatrix4x4[2][3] = 'T';
        dnaMatrix4x4[3][0] = 'A';
        dnaMatrix4x4[3][1] = 'A';
        dnaMatrix4x4[3][2] = 'G';
        dnaMatrix4x4[3][3] = 'A';
        return dnaMatrix4x4;
    }

    public static char[][] getDnaMatrix4x4WithSequenceFourEqualLettersVertical() {
        char[][] dnaMatrix4x4 = new char[4][4];
        dnaMatrix4x4[0][0] = 'G';
        dnaMatrix4x4[0][1] = 'C';
        dnaMatrix4x4[0][2] = 'G';
        dnaMatrix4x4[0][3] = 'A';
        dnaMatrix4x4[1][0] = 'G';
        dnaMatrix4x4[1][1] = 'T';
        dnaMatrix4x4[1][2] = 'G';
        dnaMatrix4x4[1][3] = 'C';
        dnaMatrix4x4[2][0] = 'A';
        dnaMatrix4x4[2][1] = 'T';
        dnaMatrix4x4[2][2] = 'G';
        dnaMatrix4x4[2][3] = 'T';
        dnaMatrix4x4[3][0] = 'A';
        dnaMatrix4x4[3][1] = 'A';
        dnaMatrix4x4[3][2] = 'G';
        dnaMatrix4x4[3][3] = 'G';
        return dnaMatrix4x4;
    }

    public static char[][] getDnaMatrix4x4WithSequenceFourEqualLettersHorizontal() {
        char[][] dnaMatrix4x4 = new char[4][4];
        dnaMatrix4x4[0][0] = 'T';
        dnaMatrix4x4[0][1] = 'T';
        dnaMatrix4x4[0][2] = 'A';
        dnaMatrix4x4[0][3] = 'T';
        dnaMatrix4x4[1][0] = 'A';
        dnaMatrix4x4[1][1] = 'G';
        dnaMatrix4x4[1][2] = 'A';
        dnaMatrix4x4[1][3] = 'A';
        dnaMatrix4x4[2][0] = 'C';
        dnaMatrix4x4[2][1] = 'C';
        dnaMatrix4x4[2][2] = 'C';
        dnaMatrix4x4[2][3] = 'C';
        dnaMatrix4x4[3][0] = 'T';
        dnaMatrix4x4[3][1] = 'C';
        dnaMatrix4x4[3][2] = 'A';
        dnaMatrix4x4[3][3] = 'C';
        return dnaMatrix4x4;
    }

    public static char[][] getDnaMatrix4x4WithoutNoneSequenceOfFourEqualLetters() {
        char[][] dnaMatrix4x4 = new char[4][4];
        dnaMatrix4x4[0][0] = 'A';
        dnaMatrix4x4[0][1] = 'T';
        dnaMatrix4x4[0][2] = 'G';
        dnaMatrix4x4[0][3] = 'C';
        dnaMatrix4x4[1][0] = 'C';
        dnaMatrix4x4[1][1] = 'A';
        dnaMatrix4x4[1][2] = 'G';
        dnaMatrix4x4[1][3] = 'T';
        dnaMatrix4x4[2][0] = 'T';
        dnaMatrix4x4[2][1] = 'T';
        dnaMatrix4x4[2][2] = 'A';
        dnaMatrix4x4[2][3] = 'T';
        dnaMatrix4x4[3][0] = 'A';
        dnaMatrix4x4[3][1] = 'G';
        dnaMatrix4x4[3][2] = 'A';
        dnaMatrix4x4[3][3] = 'C';
        return dnaMatrix4x4;
    }

    public static char[][] getDnaMatrix6x6WithObliqueSequenceFourEqualLetters() {
        char[][] dnaMatrix6x6 = new char[6][6];
        dnaMatrix6x6[0][0] = 'A';
        dnaMatrix6x6[0][1] = 'T';
        dnaMatrix6x6[0][2] = 'G';
        dnaMatrix6x6[0][3] = 'C';
        dnaMatrix6x6[0][4] = 'G';
        dnaMatrix6x6[0][5] = 'A';
        dnaMatrix6x6[1][0] = 'C';
        dnaMatrix6x6[1][1] = 'A';
        dnaMatrix6x6[1][2] = 'G';
        dnaMatrix6x6[1][3] = 'T';
        dnaMatrix6x6[1][4] = 'G';
        dnaMatrix6x6[1][5] = 'C';
        dnaMatrix6x6[2][0] = 'T';
        dnaMatrix6x6[2][1] = 'T';
        dnaMatrix6x6[2][2] = 'A';
        dnaMatrix6x6[2][3] = 'T';
        dnaMatrix6x6[2][4] = 'G';
        dnaMatrix6x6[2][5] = 'T';
        dnaMatrix6x6[3][0] = 'A';
        dnaMatrix6x6[3][1] = 'G';
        dnaMatrix6x6[3][2] = 'A';
        dnaMatrix6x6[3][3] = 'A';
        dnaMatrix6x6[3][4] = 'C';
        dnaMatrix6x6[3][5] = 'G';
        dnaMatrix6x6[4][0] = 'C';
        dnaMatrix6x6[4][1] = 'T';
        dnaMatrix6x6[4][2] = 'C';
        dnaMatrix6x6[4][3] = 'C';
        dnaMatrix6x6[4][4] = 'T';
        dnaMatrix6x6[4][5] = 'A';
        dnaMatrix6x6[5][0] = 'T';
        dnaMatrix6x6[5][1] = 'C';
        dnaMatrix6x6[5][2] = 'A';
        dnaMatrix6x6[5][3] = 'C';
        dnaMatrix6x6[5][4] = 'T';
        dnaMatrix6x6[5][5] = 'G';
        return dnaMatrix6x6;
    }

    public static char[][] getDnaMatrix6x6WithInverseObliqueSequenceFourEqualLetters() {
        char[][] dnaMatrix6x6 = new char[6][6];
        dnaMatrix6x6[0][0] = 'A';
        dnaMatrix6x6[0][1] = 'T';
        dnaMatrix6x6[0][2] = 'G';
        dnaMatrix6x6[0][3] = 'C';
        dnaMatrix6x6[0][4] = 'G';
        dnaMatrix6x6[0][5] = 'A';
        dnaMatrix6x6[1][0] = 'C';
        dnaMatrix6x6[1][1] = 'A';
        dnaMatrix6x6[1][2] = 'G';
        dnaMatrix6x6[1][3] = 'T';
        dnaMatrix6x6[1][4] = 'G';
        dnaMatrix6x6[1][5] = 'A';
        dnaMatrix6x6[2][0] = 'T';
        dnaMatrix6x6[2][1] = 'T';
        dnaMatrix6x6[2][2] = 'A';
        dnaMatrix6x6[2][3] = 'T';
        dnaMatrix6x6[2][4] = 'C';
        dnaMatrix6x6[2][5] = 'T';
        dnaMatrix6x6[3][0] = 'A';
        dnaMatrix6x6[3][1] = 'G';
        dnaMatrix6x6[3][2] = 'C';
        dnaMatrix6x6[3][3] = 'C';
        dnaMatrix6x6[3][4] = 'G';
        dnaMatrix6x6[3][5] = 'G';
        dnaMatrix6x6[4][0] = 'C';
        dnaMatrix6x6[4][1] = 'T';
        dnaMatrix6x6[4][2] = 'C';
        dnaMatrix6x6[4][3] = 'C';
        dnaMatrix6x6[4][4] = 'T';
        dnaMatrix6x6[4][5] = 'A';
        dnaMatrix6x6[5][0] = 'T';
        dnaMatrix6x6[5][1] = 'C';
        dnaMatrix6x6[5][2] = 'A';
        dnaMatrix6x6[5][3] = 'C';
        dnaMatrix6x6[5][4] = 'T';
        dnaMatrix6x6[5][5] = 'G';
        return dnaMatrix6x6;
    }

    public static char[][] getDnaMatrix6x6WithSequenceFourEqualLettersVertical() {
        char[][] dnaMatrix6x6 = new char[6][6];
        dnaMatrix6x6[0][0] = 'T';
        dnaMatrix6x6[0][1] = 'T';
        dnaMatrix6x6[0][2] = 'G';
        dnaMatrix6x6[0][3] = 'C';
        dnaMatrix6x6[0][4] = 'G';
        dnaMatrix6x6[0][5] = 'A';
        dnaMatrix6x6[1][0] = 'C';
        dnaMatrix6x6[1][1] = 'A';
        dnaMatrix6x6[1][2] = 'G';
        dnaMatrix6x6[1][3] = 'T';
        dnaMatrix6x6[1][4] = 'G';
        dnaMatrix6x6[1][5] = 'C';
        dnaMatrix6x6[2][0] = 'T';
        dnaMatrix6x6[2][1] = 'T';
        dnaMatrix6x6[2][2] = 'A';
        dnaMatrix6x6[2][3] = 'T';
        dnaMatrix6x6[2][4] = 'G';
        dnaMatrix6x6[2][5] = 'T';
        dnaMatrix6x6[3][0] = 'A';
        dnaMatrix6x6[3][1] = 'G';
        dnaMatrix6x6[3][2] = 'A';
        dnaMatrix6x6[3][3] = 'A';
        dnaMatrix6x6[3][4] = 'G';
        dnaMatrix6x6[3][5] = 'G';
        dnaMatrix6x6[4][0] = 'A';
        dnaMatrix6x6[4][1] = 'C';
        dnaMatrix6x6[4][2] = 'C';
        dnaMatrix6x6[4][3] = 'C';
        dnaMatrix6x6[4][4] = 'T';
        dnaMatrix6x6[4][5] = 'A';
        dnaMatrix6x6[5][0] = 'T';
        dnaMatrix6x6[5][1] = 'C';
        dnaMatrix6x6[5][2] = 'A';
        dnaMatrix6x6[5][3] = 'C';
        dnaMatrix6x6[5][4] = 'T';
        dnaMatrix6x6[5][5] = 'G';
        return dnaMatrix6x6;
    }

    public static char[][] getDnaMatrix6x6WithSequenceFourEqualLettersHorizontal() {
        char[][] dnaMatrix6x6 = new char[6][6];
        dnaMatrix6x6[0][0] = 'C';
        dnaMatrix6x6[0][1] = 'T';
        dnaMatrix6x6[0][2] = 'G';
        dnaMatrix6x6[0][3] = 'C';
        dnaMatrix6x6[0][4] = 'A';
        dnaMatrix6x6[0][5] = 'A';
        dnaMatrix6x6[1][0] = 'C';
        dnaMatrix6x6[1][1] = 'A';
        dnaMatrix6x6[1][2] = 'G';
        dnaMatrix6x6[1][3] = 'T';
        dnaMatrix6x6[1][4] = 'G';
        dnaMatrix6x6[1][5] = 'C';
        dnaMatrix6x6[2][0] = 'T';
        dnaMatrix6x6[2][1] = 'T';
        dnaMatrix6x6[2][2] = 'A';
        dnaMatrix6x6[2][3] = 'T';
        dnaMatrix6x6[2][4] = 'G';
        dnaMatrix6x6[2][5] = 'T';
        dnaMatrix6x6[3][0] = 'A';
        dnaMatrix6x6[3][1] = 'G';
        dnaMatrix6x6[3][2] = 'A';
        dnaMatrix6x6[3][3] = 'A';
        dnaMatrix6x6[3][4] = 'G';
        dnaMatrix6x6[3][5] = 'G';
        dnaMatrix6x6[4][0] = 'C';
        dnaMatrix6x6[4][1] = 'C';
        dnaMatrix6x6[4][2] = 'C';
        dnaMatrix6x6[4][3] = 'C';
        dnaMatrix6x6[4][4] = 'T';
        dnaMatrix6x6[4][5] = 'A';
        dnaMatrix6x6[5][0] = 'T';
        dnaMatrix6x6[5][1] = 'C';
        dnaMatrix6x6[5][2] = 'A';
        dnaMatrix6x6[5][3] = 'C';
        dnaMatrix6x6[5][4] = 'T';
        dnaMatrix6x6[5][5] = 'G';
        return dnaMatrix6x6;
    }

    public static char[][] getDnaMatrix6x6WithSequencesFourEqualLettersVerticalHorizontalAndOblique() {
        char[][] dnaMatrix6x6 = new char[6][6];
        dnaMatrix6x6[0][0] = 'A';
        dnaMatrix6x6[0][1] = 'T';
        dnaMatrix6x6[0][2] = 'G';
        dnaMatrix6x6[0][3] = 'T';
        dnaMatrix6x6[0][4] = 'G';
        dnaMatrix6x6[0][5] = 'A';
        dnaMatrix6x6[1][0] = 'C';
        dnaMatrix6x6[1][1] = 'A';
        dnaMatrix6x6[1][2] = 'T';
        dnaMatrix6x6[1][3] = 'T';
        dnaMatrix6x6[1][4] = 'G';
        dnaMatrix6x6[1][5] = 'C';
        dnaMatrix6x6[2][0] = 'T';
        dnaMatrix6x6[2][1] = 'T';
        dnaMatrix6x6[2][2] = 'A';
        dnaMatrix6x6[2][3] = 'T';
        dnaMatrix6x6[2][4] = 'G';
        dnaMatrix6x6[2][5] = 'T';
        dnaMatrix6x6[3][0] = 'T';
        dnaMatrix6x6[3][1] = 'G';
        dnaMatrix6x6[3][2] = 'A';
        dnaMatrix6x6[3][3] = 'A';
        dnaMatrix6x6[3][4] = 'G';
        dnaMatrix6x6[3][5] = 'G';
        dnaMatrix6x6[4][0] = 'C';
        dnaMatrix6x6[4][1] = 'C';
        dnaMatrix6x6[4][2] = 'C';
        dnaMatrix6x6[4][3] = 'C';
        dnaMatrix6x6[4][4] = 'T';
        dnaMatrix6x6[4][5] = 'A';
        dnaMatrix6x6[5][0] = 'T';
        dnaMatrix6x6[5][1] = 'C';
        dnaMatrix6x6[5][2] = 'A';
        dnaMatrix6x6[5][3] = 'C';
        dnaMatrix6x6[5][4] = 'T';
        dnaMatrix6x6[5][5] = 'G';
        return dnaMatrix6x6;
    }
}