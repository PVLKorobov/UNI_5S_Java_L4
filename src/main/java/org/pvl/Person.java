package org.pvl;

import java.util.Date;

/// Person class
/// Holds info about a person
public class Person {
    // Class methods
    /// Class constructor
    /// @param id row id in the table
    /// @param name person name
    /// @param gender person gender
    /// @param divisionName name of the division person is assigned to
    /// @param salary person salary
    /// @param birthDate person date of birth
    public Person(long id, String name, String gender, char divisionName, int salary, String birthDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.birthDate = birthDate;

        if (Division.exists(divisionName)) {
            this.division = Division.getExisting(divisionName);
        }
        else {
            this.division = new Division((int) divisionName, divisionName);
        }
    }

    /// Division reference getter
    /// @return reference to division this person is assigned to
    public Division getDivisionRef() {
        return division;
    }


    /// toString override
    /// @return String representation of the object
    public String toString() {
        return "| " + "ID: " + id + "; Name: " + name + "; Division: " + division.getId() + " |";
    }

    //


    // Class members
    /// Person id in the table. Is numerical
    private long id;
    /// Person name
    private String name;
    /// Person gender. Represented like "Male", "Female"
    private String gender;
    /// Reference to a division object this person is assigned to
    private Division division;
    /// Person salary. Is integer
    private int salary;
    /// Person date of birth
    private String birthDate;
    //
}
