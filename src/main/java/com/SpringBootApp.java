package com;
import java.io.IOException;
import java.util.Properties;

import org.quartz.JobBuilder;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
/*import org.springframework.data.jpa.repository.config.EnableJpaAuditing;*/
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.quartz.SampleJob;
import com.AutowiringSpringBeanJobFactory;


/*@ComponentScan("com")*/
@SpringBootApplication
/*@EnableJpaAuditing*/
public class SpringBootApp 
{
	  @Autowired
	    private ApplicationContext applicationContext;
	
	
     public static void main(String[] args) 
     {
    	
         SpringApplication.run(SpringBootApp.class, args);
     }
     
     @Bean
     public HibernateJpaSessionFactoryBean sessionFactory() {
         return new HibernateJpaSessionFactoryBean();
     }
     
     
    /* @Bean
 	public JobDetail sampleJobDetail() {
    	 System.out.println("inside sampleJobDetail");
 		return JobBuilder.newJob(SampleJob.class).withIdentity("sampleJob")
 				.usingJobData("name", "World").storeDurably().build();
 	}

 	@Bean
 	public Trigger sampleJobTrigger() {
 		System.out.println("inside sampleJobTrigger");
 		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
 				.withIntervalInSeconds(2).repeatForever();

 		return TriggerBuilder.newTrigger().forJob(sampleJobDetail())
 				.withIdentity("sampleTrigger").withSchedule(scheduleBuilder).build();
 	}
*/
     
     
     @Bean
     public JobDetail jobDetail() {
         return JobBuilder.newJob().ofType(SampleJob.class)
           .storeDurably()
           .withIdentity("Qrtz_Job_Detail")  
           .withDescription("Invoke Sample Job service...")
           .build();
     }
     
    
     
     @Bean
     public SimpleTriggerFactoryBean trigger(JobDetail job) {
         SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
         trigger.setJobDetail(job);
         trigger.setRepeatInterval(60000);
         trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
         return trigger;
     }
     
     
     @Bean
     public Scheduler scheduler(Trigger trigger, JobDetail job) throws SchedulerException, IOException {
         StdSchedulerFactory factory = new StdSchedulerFactory();
         factory.initialize(new ClassPathResource("quartz.properties").getInputStream());
      
         Scheduler scheduler = factory.getScheduler();
         scheduler.setJobFactory(springBeanJobFactory());
         scheduler.scheduleJob(job, trigger);
      
         scheduler.start();
         return scheduler;
     }
   
     
     @Bean
     public SpringBeanJobFactory springBeanJobFactory() {
    		AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
         jobFactory.setApplicationContext(applicationContext);
         return jobFactory;
     }
     
     
     
     
     
     
   /*  @Bean
     public JavaMailSender getJavaMailSender() {
         JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
         mailSender.setHost("smtp.gmail.com");
         mailSender.setPort(587);
          
         mailSender.setUsername("xproforyou");
         mailSender.setPassword("password@900");
          
         Properties props = mailSender.getJavaMailProperties();
         props.put("mail.transport.protocol", "smtp");
         props.put("mail.smtp.auth", "true");
         props.put("mail.smtp.starttls.enable", "true");
         props.put("mail.debug", "true");
          
         return mailSender;
     }*/
     
}
