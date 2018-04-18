package com.cotroller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.MeetingRoomDao;
import com.dao.RoomUserDao;
import com.model.MeetingRoom;
import com.model.RoomUser;






@Controller
public class LoginController {
	
	@Autowired
	RoomUserDao roomUserDao;
	
	@Autowired
	MeetingRoomDao meetingRoomDao;
	
	 @RequestMapping("/")
	 public String welcome(ModelMap model,Model registerModel) {
		 System.out.println("inside ");
		 RoomUser user = new RoomUser();
			model.addAttribute("userForm", user);
		
			/*model.addAttribute("userForm", user);*/
		 
	 return "Login";
	 }
	 
	 @RequestMapping("/register")
	 public String register(ModelMap model,Model registerModel) {
		 System.out.println("inside ");
		 
		 RoomUser user = new RoomUser();
			model.addAttribute("userForm", user);
		
			/*model.addAttribute("userForm", user);*/
		 
	 return "register";
	 }
	 
	 @RequestMapping("/login")
	 public ModelAndView showHome(@ModelAttribute("userForm") RoomUser user,
				BindingResult result, Model model,HttpServletRequest req)
	 {
		 RoomUser user1=roomUserDao.get(user.getEmailId(), user.getPassword());
		if( user1!=null)
		{
			System.out.println("inside if");
			ModelAndView homeModel=new ModelAndView("Home");
			//homeModel.addObject("username",user.getFirstName());
			System.out.println(user1.getFirstName());
			 req.setAttribute("username", user1.getFirstName());
			 ArrayList<MeetingRoom> rooms=(ArrayList<MeetingRoom>) meetingRoomDao.findAll();
			 req.setAttribute("rooms", rooms);
			return homeModel;
		}
		else
		{
			System.out.println("inside else");
		 
		 return null;
		}
	 }
	 
	 @RequestMapping("/RegisterUser")
	 public String registerUser(@ModelAttribute("userForm") RoomUser user,
				BindingResult result, Model model) {
		 
		 System.out.println("inside RegisterUser"+user.getFirstName()+" "+user.getLastName()+" "+user.getPassword());
		 roomUserDao.save(user);
					
		 return "Home";
		
	 }
	 

}
