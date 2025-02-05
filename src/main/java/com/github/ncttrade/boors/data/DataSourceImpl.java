package com.github.ncttrade.boors.data;


import com.github.ncttrade.boors.model.DataAndValue;
import com.github.ncttrade.boors.model.Title;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataSourceImpl implements DataSource {
    @Override
    public Title findById(Integer id, String company) throws IOException, CsvException {
        String csvFile = "src/main/java/com/github/ncttrade/boors/data/csv_files/".concat(company).concat(".csv");
        Title title = null;
        try (CSVReader reader = new CSVReader(new FileReader(csvFile, StandardCharsets.UTF_8))) {
            List<String[]> rows = reader.readAll();

            if (rows.isEmpty()) {
                return null;
            }

            String[] years = rows.get(0);

            for (int i = 1; i < rows.size(); i++) {
                String[] row = rows.get(i);
                if (row.length == 0) continue;

                String titleName = row[0];

                title = Title.builder()
                        .id(i - 1)
                        .name(titleName)
                        .data(new ArrayList<>())
                        .build();

                for (int j = 1; j < row.length; j++) {
                    if (j < years.length && !row[j].isEmpty()) {

                        int year = Integer.parseInt(years[j]);
                        String value = row[j];

                        DataAndValue dataAndValue = DataAndValue.builder()
                                .year(year)
                                .value(value)
                                .build();
                        title.getData().add(dataAndValue);
                    }
                }
                if (id.equals(i - 1)) {
                    return title;
                }
            }
        } catch (IOException | CsvException e) {
            throw e;
        }

        return null;
    }

    @Override
    public List<Title> findAll(String company) throws IOException, CsvException {
        String csvFile = "src/main/java/com/github/ncttrade/boors/data/csv_files/".concat(company).concat(".csv");

        List<Title> titles = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(csvFile, StandardCharsets.UTF_8))) {
            List<String[]> rows = reader.readAll();

            if (rows.isEmpty()) {
                return titles;
            }

            String[] years = rows.get(0);

            for (int i = 1; i < rows.size(); i++) {
                String[] row = rows.get(i);
                if (row.length == 0) continue;

                String titleName = row[0];

                Title title = Title.builder()
                        .id(i - 1)
                        .name(titleName)
                        .data(new ArrayList<>())
                        .build();

                for (int j = 1; j < row.length; j++) {
                    if (j < years.length && !row[j].isEmpty()) {

                        int year = Integer.parseInt(years[j]);
                        String value = row[j];

                        DataAndValue dataAndValue = DataAndValue.builder()
                                .year(year)
                                .value(value)
                                .build();
                        title.getData().add(dataAndValue);
                    }
                }

                titles.add(title);
            }
        } catch (IOException | CsvException e) {
            throw e;
        }

        return titles;
    }
}
