package org.pvl;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/// Main data reader class
/// Provides methods
public class DataReader {
    // Class methods
    /// Class constructor
    /// @throws FileNotFoundException when csv file is missing
    public DataReader(String filePath) throws IOException {
        csvReader = new CSVReaderBuilder(new FileReader(filePath))
                .withCSVParser(new CSVParserBuilder()
                        .withSeparator(';')
                        .build())
                .build();
        csvReader.skip(1);
    }

    public ArrayList<Person> getPersonList() throws CsvValidationException, IOException {
        ArrayList<Person> personsList = new ArrayList<>();

        String[] nextRow;
        while ((nextRow = csvReader.readNext()) != null) {
            personsList.add(new Person(
                    Long.parseLong(nextRow[0]),
                    nextRow[1],
                    nextRow[2],
                    nextRow[4].charAt(0),
                    Integer.parseInt(nextRow[5]),
                    nextRow[3]
                    ));
        }

        return personsList;
    }
    //


    // Class members
    CSVReader csvReader;
    //
}