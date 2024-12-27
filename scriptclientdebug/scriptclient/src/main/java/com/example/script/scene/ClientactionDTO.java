package com.example.script.scene;

import java.util.List;

import com.example.script.scene.clientscenedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ClientactionDTO {
	private Long id;
	private String description;
	private Long sceneId;
	private Integer sceneElementOrderId;

}
