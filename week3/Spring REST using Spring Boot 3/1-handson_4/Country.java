package com.cognizant.springresthandson;

public class Country {

    private String code;
    private String name;

    // Default Constructor
    public Country() {
        System.out.println("Inside Country Constructor.");
    }

    // Getter for code
    public String getCode() {
        System.out.println("Inside getCode()");
        return code;
    }

    // Setter for code
    public void setCode(String code) {
        System.out.println("Inside setCode()");
        this.code = code;
    }

    // Getter for name
    public String getName() {
        System.out.println("Inside getName()");
        return name;
    }

    // Setter for name
    public void setName(String name) {
        System.out.println("Inside setName()");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}