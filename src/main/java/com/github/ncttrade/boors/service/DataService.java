package com.github.ncttrade.boors.service;

import com.github.ncttrade.boors.exception.CompanyInvalidException;
import com.github.ncttrade.boors.model.Title;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface DataService {
    Title findById(Integer id,String company) throws IOException, CsvException, CompanyInvalidException;
    List<Title> findAll(String company) throws IOException, CsvException, CompanyInvalidException;

}
