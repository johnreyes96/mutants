package com.meli.Mutants.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

import com.meli.Mutants.dto.StatsDto;
import com.meli.Mutants.service.StatsServiceImpl;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebMvcTest(StatsController.class)
public class StatsControllerTest {

    private StatsController statsController;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StatsServiceImpl statsService;

    @BeforeEach
    void setUp() {
        this.statsController = Mockito.spy(new StatsController());
    }

    @Test
    public void getStatsWhenServiceIsInvokedThenMustReturnDNAVerificationStatisticsTest() throws Exception {
        doReturn(100L).when(statsService).getCountDNAChecks();
        doReturn(40L).when(statsService).getCountMutants();

        mvc.perform(MockMvcRequestBuilders
                        .get("/stats")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{\"count_mutant_dna\":40,\"count_human_dna\":100,\"ratio\":0.4}"));

        verify(statsService).getCountDNAChecks();
        verify(statsService).getCountMutants();
    }

    @Test
    public void getStatsDtoWhenMethodIsInvokedThenMustReturnStatsDtoTest() {
        long countDNAChecks = 3L;
        long countMutants = 2L;
        double ratio = 0.4d;
        doReturn(ratio).when(statsController).getRatio(countDNAChecks, countMutants);

        StatsDto statsResult = statsController.getStatsDto(countDNAChecks, countMutants);

        assertEquals(countMutants, statsResult.getCount_mutant_dna());
        assertEquals(countDNAChecks, statsResult.getCount_human_dna());
        assertEquals(ratio, statsResult.getRatio());
        verify(statsController).getRatio(countDNAChecks, countMutants);
    }

    @Test
    public void getRatioWhenCountDNAChecksIsEqualsToZeroThenMustReturnZeroTest() {
        long countDNAChecks = 0L;
        long countMutants = 0L;
        double ratioExpected = 0d;

        Double ratio = statsController.getRatio(countDNAChecks, countMutants);

        assertEquals(ratioExpected, ratio);
    }

    @Test
    public void getRatioWhenCountDNAChecksIsDifferentToZeroThenMustReturnRatioDifferentToZeroTest() {
        long countDNAChecks = 3L;
        long countMutants = 2L;
        double ratioExpected = 0.67d;

        Double ratio = statsController.getRatio(countDNAChecks, countMutants);

        assertEquals(ratioExpected, ratio);
    }

    @AfterEach
    void tearDown() {
        this.statsController = null;
    }
}