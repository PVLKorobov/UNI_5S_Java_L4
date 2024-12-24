package org.pvl;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
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
    /// Class constructors
    public DataReader(String filePath) throws IOException {
        fileNameCache = filePath;
    }

    /// Person list getter
    /// Parses dataset to list of Person objects
    /// @return ArrayList of Person objects
    public ArrayList<Person> getPersonList() throws CsvValidationException, IOException {
        ArrayList<Person> personsList = new ArrayList<>();
        CSVReader csvReader = buildReader();

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

    /// Rows count getter
    /// @return int - amount of rows in the file excluding column names
    /// @throws FileNotFoundException when csv file is missing
    public int getRowsCount() throws IOException, CsvException {
        CSVReader csvReader = buildReader();
        return csvReader.readAll().size();
    }


    /// Reader builder method
    /// Builds a reader object pointing to the second line of the file with ';' as separator
    /// @return built CSVReader object, skipping the first line of column names in the csv file
    /// @throws FileNotFoundException when csv file is missing
    private CSVReader buildReader() throws FileNotFoundException {
        return new CSVReaderBuilder(new FileReader(fileNameCache))
                .withCSVParser(new CSVParserBuilder()
                        .withSeparator(';')
                        .build())
                .withSkipLines(1)
                .build();
    }
    //


    // Class members
    /// File name given at initialization
    private String fileNameCache;
    //
}