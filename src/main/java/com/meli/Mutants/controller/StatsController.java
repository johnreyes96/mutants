package com.meli.Mutants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.meli.Mutants.dto.StatsDto;
import com.meli.Mutants.service.StatsServiceImpl;

@RestController
@RequestMapping(StatsController.ROUTE)
public class StatsController {

    public static final String ROUTE = "/stats";

    @Autowired
    private StatsServiceImpl statsService;

    @GetMapping("")
    public StatsDto getStats() {
        long countDNAChecks = statsService.getCountDNAChecks();
        long countMutants = statsService.getCountMutants();
        return getStatsDto(countDNAChecks, countMutants);
    }

    protected StatsDto getStatsDto(long countDNAChecks, long countMutants) {
        StatsDto statsDto = new StatsDto();
        statsDto.setCount_mutant_dna(countMutants);
        statsDto.setCount_human_dna(countDNAChecks);
        statsDto.setRatio(getRatio(countDNAChecks, countMutants));
        return statsDto;
    }

    protected Double getRatio(long countDNAChecks, long countMutants) {
        double ratio = 0d;
        if (countDNAChecks > 0) {
            ratio = BigDecimal.valueOf(Long.valueOf(countMutants).doubleValue() / Long.valueOf(countDNAChecks).doubleValue())
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();
        }
        return ratio;
    }
}