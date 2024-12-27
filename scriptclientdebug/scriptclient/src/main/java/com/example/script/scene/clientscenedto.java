package com.example.script.scene;

import java.util.List;


import com.example.script.location.clientlocationdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data


public class clientscenedto {
	private Long id;
private ClientlocationDto locationDto;
	private Integer timeId;
	private Long scriptId;
	private List<ClientactionDTO> actionList;
    private List<ClientdialogueDTO> dialogueList;
    
    
}
