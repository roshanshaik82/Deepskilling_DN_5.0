package com.cognizant.springlearn.service;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.model.Country;

@Service
public class CountryService {

    public Country getCountry(String code) {

        // Load country.xml
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        // Get the country list
        List<Country> countryList =
                context.getBean("countryList", List.class);

        // Search for the country (case-insensitive)
        for (Country country : countryList) {
            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }
        }

        // Return null if no country is found
        return null;
    }
}