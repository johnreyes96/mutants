package com.meli.Mutants.controller;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Arrays;

import com.meli.Mutants.factory.DNAFactory;
import com.meli.Mutants.model.DNA;
import com.meli.Mutants.service.StatsServiceImpl;
import com.meli.Mutants.factory.DNADtoFactory;
import com.meli.Mutants.factory.DNAMatrixFactory;
import com.meli.Mutants.dto.DNADto;
import com.meli.Mutants.service.MutantServiceImpl;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MutantController.class)
public class MutantControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MutantServiceImpl mutantService;

    @MockBean
    private StatsServiceImpl statsService;

    @Test
    public void isMutantWhenDNAHasNotBeenValidatedAndIsMutantThenMustReturnOkTest() throws Exception {
        String[] dnaArray = new String[0];
        DNADto dnaDto = DNADtoFactory.unDNADto().conDNA(dnaArray).getInstance();
        doReturn(false).when(mutantService).isMutant(dnaDto.getDna());

        mvc.perform(MockMvcRequestBuilders
                        .post("/mutant/")
                        .content("{\"dna\":[]}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isForbidden());

        verify(mutantService).isMutant(dnaDto.getDna());
    }

    @Test
    public void isMutantWhenDNAHasNotBeenValidatedAndIsNotMutantThenMustReturnForbiddenTest() throws Exception {
        String[] dnaArray = DNAMatrixFactory.getDnaArray6x6();
        dnaArray[5] = "GGGGGG";
        DNADto dnaDto = DNADtoFactory.unDNADto().conDNA(dnaArray).getInstance();
        doReturn(false).when(mutantService).isMutant(dnaDto.getDna());

        mvc.perform(MockMvcRequestBuilders
                        .post("/mutant/")
                        .content("{\"dna\":[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"GGGGGG\"]}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isForbidden());

        verify(mutantService).isMutant(dnaDto.getDna());
    }

    @Test
    public void isMutantWhenDNAHasBeenValidatedAndIsMutantThenMustReturnOkTest() throws Exception {
        DNADto dnaDto = DNADtoFactory.unDNADto().conDNA(DNAMatrixFactory.getDnaArray6x6()).getInstance();
        DNA dna = DNAFactory.unDNA().conIsMutant(true).getInstance();
        doReturn(dna).when(statsService).findDNAByDNA(Arrays.toString(dnaDto.getDna()));

        mvc.perform(MockMvcRequestBuilders
                        .post("/mutant/")
                        .content("{\"dna\":[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(statsService).findDNAByDNA(Arrays.toString(dnaDto.getDna()));
        verify(mutantService, Mockito.never()).isMutant(Mockito.any());
    }

    @Test
    public void isMutantWhenDNAHasBeenValidatedAndIsNotMutantThenMustReturnForbiddenTest() throws Exception {
        DNADto dnaDto = DNADtoFactory.unDNADto().conDNA(DNAMatrixFactory.getDnaArray3x3()).getInstance();
        DNA dna = DNAFactory.unDNA().conIsMutant(false).getInstance();
        doReturn(dna).when(statsService).findDNAByDNA(Arrays.toString(dnaDto.getDna()));

        mvc.perform(MockMvcRequestBuilders
                        .post("/mutant/")
                        .content("{\"dna\":[\"ATG\",\"CAG\",\"TTA\"]}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isForbidden());

        verify(statsService).findDNAByDNA(Arrays.toString(dnaDto.getDna()));
        verify(mutantService, Mockito.never()).isMutant(Mockito.any());
    }
}