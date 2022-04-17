package com.meli.Mutants.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.meli.Mutants.model.DNA;

public interface IDNADao extends CrudRepository<DNA, Long> {

    @Query(value = "select count(*) from tbl_dna dna where dna.is_mutant is true", nativeQuery = true)
    int getCountMutants();

    @Query("select dna from DNA dna where dna.dna = ?1")
    DNA findDNAByDNA(String dna);
}