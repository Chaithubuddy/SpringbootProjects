package com.example.script.scene;

import java.util.List;

import com.example.script.scene.clientscenedto;
import com.example.script.scriptcharector.clientscriptcharectordto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ClientdialogueDTO {
	 private Long id;
	  private String content;
	  private String parantical;
	  private Long sceneID;
	  private Integer sceneElementOrderId;
	  private clientscriptcharectordto scDTO;

}
