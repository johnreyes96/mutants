package com.meli.Mutants.service;

import com.meli.Mutants.model.DNA;

public interface IStatsService {

    void saveDNA(DNA dna);

    DNA findDNAByDNA(String dna);

    long getCountDNAChecks();

    long getCountMutants();
}