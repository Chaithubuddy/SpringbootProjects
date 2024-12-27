package com.chaithu.narvee.DTO;

import com.chaithu.narvee.enums.Gender;

import lombok.Data;

@Data
public class OwnerDTO {
	private int id;
	private String firstName;
	private String lastName;
	private Gender gender;
	private String city;
	private String state;
	private String mobileNumber;
	private String emailId;
	private PetDTO petDTO;

}
