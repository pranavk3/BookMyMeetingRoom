package com.quartz;

import java.text.ParseException;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;


@Component
public class SampleJob implements Job {
 
    @Autowired
    private SampleJobService jobService;
 
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
			jobService.executeSampleJob();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}