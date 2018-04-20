package com.cotroller;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.MeetingDao;
import com.dao.MeetingProcessDao;
import com.model.Meeting;
import com.model.MeetingRoom;
import com.util.RoomAndMeeting;

@Controller
public class MeetingController {
	
	@Autowired
	MeetingDao meetingDao;
	
	@Autowired
	MeetingProcessDao meetingProcessDao;
	
	 @RequestMapping("/book{id}")
	 public ModelAndView book(@PathVariable("id")Long i ,HttpSession session,HttpServletRequest req,Model model)
	 {
		 System.out.println("inside book"+ i);
		 ModelAndView mv=new ModelAndView("bookMeetingRoom");
		 
		List <MeetingRoom>roomList=(List<MeetingRoom>)session.getAttribute("meetingRooms");
		MeetingRoom meetingRoom = null;
		
		for(MeetingRoom mr:roomList)
		{
			if(mr.getRoomId()==i)
			{
				meetingRoom=mr;
			}
		}
		 req.setAttribute("meetingRoom", meetingRoom);
		 
		 Meeting meeting=new Meeting();
		 model.addAttribute("meetingForm",meeting);
		return mv;
		 
	 }
	 
	 
	 
	 @RequestMapping("savemeeting")
	 String saveMeetingRoom(@ModelAttribute("meetingForm") Meeting meeting,
				BindingResult result, Model model,HttpSession session)
	 {
		 System.out.println("inside saving meeting");
		 try{
		System.out.println("inside savemeeting "+meeting.getDateFrom()+meeting.getDateTo()+meeting.gettFrom()+meeting.gettTo());
		
		 
	
	
	/*String s = meeting.gettFrom();  your date string here ;
	SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
	long ms = sdf.parse(s).getTime();
	Time t = new Time(ms);*/
	
	meeting.setTimeFrom( meeting.gettFrom());
	
	/*String s1 = meeting.gettTo();  your date string here ;
	SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm");
	long ms1 = sdf.parse(s1).getTime();
	Time t1 = new Time(ms1);*/
	
	meeting.setTimeTo(meeting.gettTo());
	 
	meeting.setCreatedBy((String)session.getAttribute("emailId"));
	
	meetingDao.save(meeting);
	
	
		 
		 
		 
		 }catch(Exception e){e.printStackTrace();}
		 
		return "success";
		 
	 }
	 
	 
	 @RequestMapping("/showMeeting")
	 public ModelAndView showMeeting(HttpSession session,HttpServletRequest req)
	 {
		 ModelAndView mv=new ModelAndView("bookedRooms");
		List<Meeting>meetings= meetingProcessDao.get((String)session.getAttribute("emailId"));
		
		session.setAttribute("bookedMeetings", meetings);
		
		List<MeetingRoom>rooms=(List<MeetingRoom>)session.getAttribute("meetingRooms");
		
		ArrayList<RoomAndMeeting>finalList=new ArrayList();
		
		for(Meeting meeting:meetings)
		{
			
			for(MeetingRoom meetingroom:rooms)
			{
				if(meeting.getMeetingRoomName().equalsIgnoreCase(meetingroom.getRoomName()))
				{
					RoomAndMeeting ram=new RoomAndMeeting();
					ram.setRoomName(meeting.getMeetingRoomName());
					ram.setRoomDescr(meetingroom.getRoomDescr());
					ram.setRoomAddress(meetingroom.getRoomAddress());
					ram.setImageUrl(meetingroom.getImageUrl());
					ram.setDateFrom(meeting.getDateFrom());
					ram.setDateTo(meeting.getDateTo());
					ram.setTimeFrom(meeting.getTimeFrom());
					ram.setTimeTo(meeting.getTimeTo());
					ram.setMeetingId(meeting.getMeetingId());
					
					finalList.add(ram);
					
				}
			}
			
		}
		
		
		
		 req.setAttribute("rooms",finalList );
		 
		return mv;
		 
	 }
	 
	 @RequestMapping("/delete{id}")
	 public String deleteMeeting(@PathVariable("id")Long i ,HttpSession session,HttpServletRequest req,Model model)
	 {
		 
		 meetingDao.delete(i);
		 
		return "redirect:/showMeeting";
		 
	 }
	 
	 @RequestMapping("/update{id}")
	 public ModelAndView updateMeeting(@PathVariable("id")Long i ,HttpSession session,HttpServletRequest req,Model model)
	 {
		 ModelAndView mv=new ModelAndView("UpdateMeeting");
		 List<Meeting>meetings=(List<Meeting>)session.getAttribute("bookedMeetings");
		 Meeting toBeUpdate = null;
		 
		 for(Meeting m:meetings)
		 {
			 if(m.getMeetingId()==i)
			 {
				 toBeUpdate=m;
			 }
		 }
 req.setAttribute("meetingRoom", toBeUpdate);
		 
		 Meeting meeting=new Meeting();
		 model.addAttribute("meetingForm",meeting);
		 
		return mv;
		 
	 }
	
	
	 
	 @RequestMapping("/updatemeeting")
	 public String updateMeeting(@ModelAttribute("meetingForm") Meeting meeting,
				BindingResult result, Model model,HttpSession session)
	 {
		 
		 System.out.println("inside update");
		 meeting.setCreatedBy((String) session.getAttribute("emailId"));
		 meetingProcessDao.update(meeting);
		return "redirect:/showMeeting";
		 
	 }
	 

}
