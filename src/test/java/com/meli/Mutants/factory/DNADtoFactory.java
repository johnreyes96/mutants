package com.meli.Mutants.factory;

import com.meli.Mutants.model.DNADto;

public class DNADtoFactory implements IFactory<DNADto> {

    private String[] dna;

    public DNADtoFactory() {
        this.dna = null;
    }

    public DNADtoFactory conDNA(String[] dna) {
        this.dna = dna;
        return this;
    }

    public static DNADtoFactory unDNADto() {
        return new DNADtoFactory();
    }

    @Override
    public DNADto getInstance() {
        return new DNADto(this.dna);
    }
}