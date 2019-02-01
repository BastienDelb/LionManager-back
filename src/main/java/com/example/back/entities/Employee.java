package com.example.back.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="employees")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String lastName;
	private String firstName;
	private String nationality;
	private Long age;
	private String address;
	private Long number;
	private String mail;
	private String sector;
	private String[] skills;
	private Long remuneration;
	private String imageUrl;

}
