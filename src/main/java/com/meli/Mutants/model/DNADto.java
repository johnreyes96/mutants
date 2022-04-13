package com.meli.Mutants.model;

public class DNADto {

    private String[] dna;

    public DNADto() {}

    public DNADto(String[] dna) {
        this.dna = dna;
    }

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }
}