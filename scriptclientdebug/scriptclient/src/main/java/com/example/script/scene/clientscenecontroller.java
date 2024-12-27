package com.example.script.scene;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


//import com.example.script.entity.ClientdialogueDTO;

import com.example.script.scriptcharector.clientscriptcharectordto;

public class clientscenecontroller {
	
		public static void main1(String[] args) {
			RestTemplate restTemplate = new RestTemplate();
			clientscenedto scene=new clientscenedto();
			
			ClientlocationDto location=new ClientlocationDto();
			location.setName("SRNAGAR");
			location.setTypeId(2);
			    
			scene.setLocationDto(location);
			
			scene.setTimeId(4);
			
			scene.setScriptId(1L);
			
			ClientactionDTO action1=new ClientactionDTO();
			action1.setDescription("Action1");
			
			action1.setSceneElementOrderId(1);
			
			ClientactionDTO action2=new ClientactionDTO();
			action2.setDescription("Action2");
			
			action2.setSceneElementOrderId(3);
			
			List<ClientactionDTO> actionList=new ArrayList<>();
			
			actionList.add(action1);
			actionList.add(action2);
			scene.setActionList(actionList);
			
			
			
			ClientdialogueDTO dialogue1=new ClientdialogueDTO();
			dialogue1.setContent(" asdfas fasdf ");
			dialogue1.setParantical("asdfasd");
			dialogue1.setSceneElementOrderId(2);
			
			
			clientscriptcharectordto ScritpChar1=new clientscriptcharectordto();
			ScritpChar1.setName("ABC1");
			dialogue1.setScDTO(ScritpChar1);
			
			ClientdialogueDTO dialogue2 = new ClientdialogueDTO();
			dialogue2.setContent(" VDSerawera ");
			dialogue2.setParantical("asdfasd");
			dialogue2.setSceneElementOrderId(4);
			
			clientscriptcharectordto ScritpChar2=new clientscriptcharectordto();
			ScritpChar2.setName("ABC2");
			dialogue2.setScDTO(ScritpChar2);
			
			List<ClientdialogueDTO> dialogueList =new ArrayList<>();
			dialogueList.add(dialogue1);
			dialogueList.add(dialogue2);
			
			scene.setDialogueList(dialogueList);
			
			clientscenedto clientDto =restTemplate.postForObject("http://localhost:8089/scene", 
					scene,
					 clientscenedto.class);
			
			System.out.println(clientDto);
		}
		public static void main2(String[] args) {
			RestTemplate restTemplate = new RestTemplate();
			clientscenedto cs=new clientscenedto();
			 ClientlocationDto c=new ClientlocationDto();
			    c.setName("ammu");
			    c.setTypeId(1);
			cs.setLocationDto(c);
			cs.setTimeId(4);
			cs.setScriptId((long) 2);
			ClientactionDTO ca=new ClientactionDTO();
			ca.setDescription("suchi");
			ca.setId((long) 1);
			ca.setSceneElementOrderId(9);
			List<ClientactionDTO> action=new ArrayList<>();
			action.add(ca);
			cs.setActionList(action);
			ClientdialogueDTO cd=new ClientdialogueDTO();
			cd.setContent("hi hello");
			cd.setParantical("way");
			cd.setSceneElementOrderId(3);
			clientscriptcharectordto cc=new clientscriptcharectordto();
			cc.setName("pavi");
			cc.setScriptId((long) 2);
			cd.setScDTO(cc);
			List<ClientdialogueDTO> charector=new ArrayList<>();
			charector.add(cd);
			cs.setDialogueList(charector);
			
			
			ResponseEntity<	clientscenedto> re = restTemplate.postForEntity("http://localhost:8089/scene",
					cs, 	 clientscenedto.class);
			
			System.out.println(re.getStatusCode());
			System.out.println(re.getStatusCodeValue());
			System.out.println(re.getHeaders());
			System.out.println(re.getBody());
			
			clientscenedto response = re.getBody();
			System.out.println(response);
			
		}
		
		


	}



