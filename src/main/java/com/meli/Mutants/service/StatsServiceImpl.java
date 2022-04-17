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

    @Override
    public DNA findDNAByDNA(String dna) {
        return idnaDao.findDNAByDNA(dna);
    }

    @Override
    public long getCountDNAChecks() {
        return idnaDao.count();
    }

    @Override
    public long getCountMutants() {
        return idnaDao.getCountMutants();
    }
}