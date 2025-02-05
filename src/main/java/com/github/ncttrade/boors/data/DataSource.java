package com.github.ncttrade.boors.data;


import com.github.ncttrade.boors.model.Title;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.List;

public interface DataSource {
    Title findById(Integer id, String company) throws IOException, CsvException;

    List<Title> findAll(String company) throws IOException, CsvException;
}
