package org.pvl;

import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/// DataReader test class
public class DataReaderTest {
    /// Class constructor
    public DataReaderTest() {

    }

    /// Foreign names dataset test
    /// Expects a list of Person type objects with members of correct type
    /// @throws FileNotFoundException if file is not found
    @Test
    public void peopleDataTest() throws IOException, CsvValidationException {
        DataReader dataReader = new DataReader(System.getProperty("user.dir") + "\\test data\\foreign_names.csv");

        ArrayList<Person> resultList = dataReader.getPersonList();
        // TODO assertion
    }
}