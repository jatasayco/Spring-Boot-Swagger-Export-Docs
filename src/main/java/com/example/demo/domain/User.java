package com.example.demo.domain;

import java.time.LocalDate;

import lombok.Data;
@Data
public class User {
    private Integer id;
	private String lastName;
    private String middleName;
    private String firstName;
    private LocalDate dateOfBirth;
    private Integer siblings;

}
