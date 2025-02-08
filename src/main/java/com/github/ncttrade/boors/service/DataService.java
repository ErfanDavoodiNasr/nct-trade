package com.github.ncttrade.boors.service;

import com.github.ncttrade.boors.exception.CompanyInvalidException;
import com.github.ncttrade.boors.model.Title;
import com.opencsv.exceptions.CsvException;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public interface DataService {
    ResponseEntity<Title> findById(Integer id, String company) throws IOException, CsvException, CompanyInvalidException;

    ResponseEntity<List<Title>> findAll(String company) throws IOException, CsvException, CompanyInvalidException;

}
