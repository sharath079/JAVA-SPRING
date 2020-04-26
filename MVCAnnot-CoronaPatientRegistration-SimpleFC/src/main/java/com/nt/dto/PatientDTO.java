package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PatientDTO implements Serializable {

	private String patName;
	private int age;
	private String location;
	private String hospital;
}
