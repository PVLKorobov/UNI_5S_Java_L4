package org.pvl;


import java.util.HashMap;

/// Division class
/// Holds info about a department
public class Division {
    // Class methods
    /// Class constructor
    /// @param id row id in the table
    /// @param divisionName name of the division
    public Division(long id, char divisionName) {
         this.id = id;
         this.name = divisionName;
         existingDivision.put(divisionName, this);
    }


    /// Division exists method
    /// Static method that checks if division with given name exists
    /// @param divisionName name of the searched division
    /// @return <code>true</code> if searched division exists, <code>false</code> otherwise
    static public boolean exists(char divisionName) {
        return existingDivision.containsKey(divisionName);
    }

    /// Existing division getter
    /// Static method that returns reference to an existing division
    /// @param divisionName name of the target division
    /// @return reference to target division
    static public Division getExisting(char divisionName) {
        return existingDivision.get(divisionName);
    }
    //


    // Class members
    /// Division id in the table. Is numerical
    private long id;
    /// Division name. Represented as a capital character, like "H", "M"
    private char name;

    /// Map of all created divisions
    /// Is shared among all class objects
    static private HashMap<Character, Division> existingDivision = new HashMap<>();
    //
}
