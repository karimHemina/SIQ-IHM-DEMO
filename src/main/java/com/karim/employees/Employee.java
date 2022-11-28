package com.karim.employees;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String position;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, String position) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    public int getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getPosition() {
        return position;
    }

}
