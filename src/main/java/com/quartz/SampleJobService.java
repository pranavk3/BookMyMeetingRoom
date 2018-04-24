package com.quartz;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MeetingProcessDao;
import com.model.Mail;
import com.model.Meeting;
import com.service.EmailService;

@Service
public class SampleJobService {
	@Autowired
	MeetingProcessDao meetingProcessDao;
	
	 @Autowired
	    private EmailService emailService;
	 
	 
	 public void executeSampleJob() throws ParseException {
		 
		 
		// DateFormat dateFormatForDate = new SimpleDateFormat("yyyy-MM-dd");
		 DateFormat dateFormatForTime = new SimpleDateFormat("HH:mm");
			Date date = new Date();
		
			String time1=dateFormatForTime.format(date);
			
			 Date d = dateFormatForTime.parse(time1); 
			 Calendar cal = Calendar.getInstance();
			 cal.setTime(d);
			 cal.add(Calendar.MINUTE, 5);
			 String newTime = dateFormatForTime.format(cal.getTime());
			
	/*String str[]=time1.split(":");
	int hrs=Integer.parseInt(str[0]);
	
	int mins=Integer.parseInt(str[1]);*/
		
			java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
			
		
			
			System.out.println("_____________"+sqlStartDate+"---------------"+newTime);
			
			
			
			try
			{
	List<Meeting>list= meetingProcessDao.getMeetingToSendMail(sqlStartDate, newTime);
	
	for(Meeting m:list)
	{
		System.out.println("****"+m.getMeetingRoomName()+" "+m.getTimeFrom());
		
		Mail mail = new Mail();
	    mail.setFrom("BookMyMeetingRoom@gmail.com");
	    mail.setTo(m.getCreatedBy());
	    mail.setSubject("Reminder of Meeting");
	    mail.setContent("Hello This mail is to notify you that you have scheduled your meeting on "+m.getTimeFrom());

	    emailService.sendSimpleMessage(mail);
	}
	

			}
			catch(Exception exc)
			{
				exc.printStackTrace();
			}
		 System.out.println("Hello world");
	 }

}
