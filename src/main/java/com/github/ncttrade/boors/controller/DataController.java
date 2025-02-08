package com.github.ncttrade.boors.controller;


import com.github.ncttrade.boors.exception.CompanyInvalidException;
import com.github.ncttrade.boors.model.DataAndValue;
import com.github.ncttrade.boors.model.Title;
import com.github.ncttrade.boors.service.DataService;
import com.opencsv.exceptions.CsvException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/boors-data")
@RequiredArgsConstructor
public class DataController {
    private final DataService dataService;

    @GetMapping("/company={company}/id={id}/year={year}")
    public ResponseEntity<Title> getDataForSingleYear(@PathVariable("company") String company, @PathVariable("id") Integer id, @PathVariable("year") Integer year) throws CompanyInvalidException, IOException, CsvException {
        ResponseEntity<Title> tile = dataService.findById(id, company);
        List<DataAndValue> years = tile.getBody().getData();
        for (DataAndValue dataAndValue : years) {
            if (dataAndValue.getYear().equals(year)) {
                tile.getBody().setData(List.of(dataAndValue));
                return tile;
            }
        }
        return ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/company={company}/id={id}")
    public ResponseEntity<Title> getDataById(@PathVariable("company") String company, @PathVariable("id") Integer id) throws CompanyInvalidException, IOException, CsvException {
        return dataService.findById(id, company);
    }

    @GetMapping("/company={company}")
    public ResponseEntity<List<Title>> getAll(@PathVariable("company") String company) throws CompanyInvalidException, IOException, CsvException {
        return dataService.findAll(company);
    }
}
