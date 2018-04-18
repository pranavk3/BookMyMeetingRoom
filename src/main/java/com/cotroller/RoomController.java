package com.cotroller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.dao.MeetingRoomDao;
import com.model.MeetingRoom;


@Controller
public class RoomController {
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private MeetingRoomDao meetingroomdao;
	
	 @RequestMapping("/createroom")
	 String showCreateRoom(Model model)
	 {
		 MeetingRoom meetingRoom=new MeetingRoom();
		 model.addAttribute("roomForm",meetingRoom);
		 return "createRoom";
	 }
	 
	 @RequestMapping("/savemeetingroom")
	 String saveMeetingRoom(@ModelAttribute("roomForm") MeetingRoom room,
				BindingResult result, Model model)
	 {
		 
		 room.setImageUrl(uploadImage(room.getFile()));
		 meetingroomdao.save(room);
		 
		 
		return "createRoom";
		 
	 }
	 

	 
	// helper to upload the file
			protected String uploadImage(MultipartFile multipartFile) {
				
				String folderToUpload = "/resources/images/";
				
				//1. get the filename
				String filename = multipartFile.getOriginalFilename();
				
				// 2. get the real path and create the directory
				// if it does not exists
				String realPath = request.getServletContext().getRealPath(folderToUpload);
				if(!new File(realPath).exists()) {
					new File(realPath).mkdirs();
				}
								
				// 3. transfer the file
				String filePath = realPath + filename;
				File destination = new File(filePath);
				try { multipartFile.transferTo(destination);	}
				catch(Exception ex) {}
				
				// 4. Return the filename
				return filename;
				
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			

}
