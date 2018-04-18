package com;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/*import org.springframework.data.jpa.repository.config.EnableJpaAuditing;*/


/*@ComponentScan("com")*/
@SpringBootApplication
/*@EnableJpaAuditing*/
public class SpringBootApp 
{
	
	
	
     public static void main(String[] args) 
     {
         SpringApplication.run(SpringBootApp.class, args);
     }
}
