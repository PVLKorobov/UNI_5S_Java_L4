package org.pvl;

import com.opencsv.CSVReader;
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
    public DataReader(String filePath) throws FileNotFoundException {
        csvReader = new CSVReader(new FileReader(filePath));
    }

    public ArrayList<Person> getPersonList() throws CsvValidationException, IOException {
        ArrayList<Person> personsList = new ArrayList<>();

        String[] nextRow;
        while ((nextRow = csvReader.readNext()) != null) {
            // TODO
        }

        return personsList;
    }
    //


    // Class members
    CSVReader csvReader;
    //
}