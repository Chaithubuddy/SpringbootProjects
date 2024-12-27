package com.chaithu.narvee.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class DomesticPetDTO extends PetDTO {

	private LocalDate birthDate;

}
