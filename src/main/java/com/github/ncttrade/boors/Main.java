package com.github.ncttrade.boors;

import com.github.ncttrade.boors.data.DataSource;
import com.github.ncttrade.boors.data.DataSourceImpl;
import com.github.ncttrade.boors.model.Title;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException, CsvException {
        DataSource dataSource = new DataSourceImpl();
        List<Title> all = dataSource.findAll("");
    }
}
