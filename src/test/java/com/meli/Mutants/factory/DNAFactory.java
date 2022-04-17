package com.meli.Mutants.factory;

import com.meli.Mutants.model.DNA;

public class DNAFactory implements IFactory<DNA> {

    private boolean isMutant;

    public DNAFactory() { }

    public DNAFactory conIsMutant(boolean isMutant) {
        this.isMutant = isMutant;
        return this;
    }

    public static DNAFactory unDNA() {
        return new DNAFactory();
    }

    @Override
    public DNA getInstance() {
        DNA dna = new DNA();
        dna.setMutant(this.isMutant);
        return dna;
    }
}