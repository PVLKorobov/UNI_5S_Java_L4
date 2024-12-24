package org.pvl;

import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/// DataReader test class
public class DataReaderTest {
    /// Class constructor
    public DataReaderTest() {

    }

    /// Foreign names dataset test
    /// Expects a list of Person type objects with members of correct type
    /// @throws FileNotFoundException if file is not found
    @Test
    public void peopleDataTest() throws IOException, CsvException {
        DataReader dataReader = new DataReader(System.getProperty("user.dir") + "\\test data\\foreign_names.csv");
        ArrayList<Person> resultList = dataReader.getPersonList();
        for (Person person : resultList) {
            System.out.println(person + " -- " + person.getDivisionRef());
        }

        Assertions.assertEquals(dataReader.getRowsCount(), resultList.size());
    }
}