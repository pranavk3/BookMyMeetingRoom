package com;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
/*import org.springframework.data.jpa.repository.config.EnableJpaAuditing;*/
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;


/*@ComponentScan("com")*/
@SpringBootApplication
/*@EnableJpaAuditing*/
public class SpringBootApp 
{
	
	
	
     public static void main(String[] args) 
     {
         SpringApplication.run(SpringBootApp.class, args);
     }
     
     @Bean
     public HibernateJpaSessionFactoryBean sessionFactory() {
         return new HibernateJpaSessionFactoryBean();
     }
}
