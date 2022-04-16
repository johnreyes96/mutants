package com.meli.Mutants.controller;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.meli.Mutants.factory.DNADtoFactory;
import com.meli.Mutants.factory.DNAMatrixFactory;
import com.meli.Mutants.model.DNADto;
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

    @Test
    public void isMutantWhenIsNotMutantThenMustReturnForbiddenTest() throws Exception {
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
    public void isMutantWhenIsMutantThenMustReturnOkTest() throws Exception {
        DNADto dnaDto = DNADtoFactory.unDNADto().conDNA(DNAMatrixFactory.getDnaArray6x6()).getInstance();
        doReturn(true).when(mutantService).isMutant(dnaDto.getDna());

        mvc.perform(MockMvcRequestBuilders
                        .post("/mutant/")
                        .content("{\"dna\":[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(mutantService).isMutant(dnaDto.getDna());
    }
}