package com.github.ncttrade.boors.service;


import com.github.ncttrade.boors.data.DataSource;
import com.github.ncttrade.boors.exception.CompanyInvalidException;
import com.github.ncttrade.boors.model.Title;
import com.opencsv.exceptions.CsvException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DataServiceImpl implements DataService {
    private final DataSource dataSource;
    private final List<String> companies = List.of("zob", "foolad", "shabandar");

    @Override
    public ResponseEntity<Title> findById(Integer id, String company) throws IOException, CsvException, CompanyInvalidException {
        if (companyIsValid(company)) {
            return ResponseEntity.ok(dataSource.findById(id, company));
        }
        return ResponseEntity.badRequest().body(null);
    }

    private boolean companyIsValid(String company) throws CompanyInvalidException {
        if (companies.contains(company)) {
            return true;
        }
        throw new CompanyInvalidException("company is invalid");
    }

    @Override
    public ResponseEntity<List<Title>> findAll(String company) throws IOException, CsvException, CompanyInvalidException {
        if (companyIsValid(company)) {
            return ResponseEntity.ok(dataSource.findAll(company));
        }
        return ResponseEntity.badRequest().body(null);
    }
}
