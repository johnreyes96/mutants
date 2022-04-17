package com.meli.Mutants.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meli.Mutants.dao.IDNADao;
import com.meli.Mutants.model.DNA;

@Service
public class StatsServiceImpl implements IStatsService {

    @Autowired
    private IDNADao idnaDao;

    @Override
    public void saveDNA(DNA dna) {
        idnaDao.save(dna);
    }

    /**
     * Search if the DNA sequence already exists in the database.
     * @param dna DNA sequence {@code String} to find
     * @return {@code DNA} if the DNA sequence exists
     */
    @Override
    public DNA findDNAByDNA(String dna) {
        return idnaDao.findDNAByDNA(dna);
    }

    /**
     * Search the total count of DNA verifications in the database.
     * @return {@code long} total count of DNA verifications
     */
    @Override
    public long getCountDNAChecks() {
        return idnaDao.count();
    }

    /**
     * Search the total mutant count of all DNA verifications in the database.
     * @return {@code long} total mutant count
     */
    @Override
    public long getCountMutants() {
        return idnaDao.getCountMutants();
    }
}