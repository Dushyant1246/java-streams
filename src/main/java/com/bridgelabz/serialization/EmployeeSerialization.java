package com.bridgelabz.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSerialization {
    public static void main(String[] args) {
        // List of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Alice", "HR", 50000));
        employees.add(new Employee(102, "Bob", "IT", 60000));
        employees.add(new Employee(103, "Charlie", "Finance", 55000));

        // File name to store serialized data
        String fileName = "src/main/resources/employees.ser";

        // Serializing employees list
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(employees);
            System.out.println("Employees data serialized successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred during serialization.");
            e.printStackTrace();
        }

        // Deserializing employees list
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Employee> deserializedEmployees = (List<Employee>) ois.readObject();
            System.out.println("Deserialized Employee Data:");
            for (Employee emp : deserializedEmployees) {
                emp.display();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error occurred during deserialization.");
            e.printStackTrace();
        }
    }
}
/*
Employees data serialized successfully.
Deserialized Employee Data:
ID: 101, Name: Alice, Department: HR, Salary: 50000.0
ID: 102, Name: Bob, Department: IT, Salary: 60000.0
ID: 103, Name: Charlie, Department: Finance, Salary: 55000.0
 */