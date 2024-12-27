package com.chaithu.narvee.DTO;

import com.chaithu.narvee.enums.Gender;
import com.chaithu.narvee.enums.PetType;

import lombok.Data;

@Data
public class PetDTO {
	private int id;
	private String name;
	private Gender gender;
	private PetType type;
	private OwnerDTO ownerDTO;

}
