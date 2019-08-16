package com.mphasis.car.conf;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.mphasis.car")

public class AppConfig {
      
     @Bean
     public DriverManagerDataSource getDataSource()
     {
     	DriverManagerDataSource ds = new DriverManagerDataSource();
     	ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
     	ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
     	ds.setUsername("bhuma");
     	ds.setPassword("1234");
     	return ds;
     	
     }
     @Bean
     public LocalSessionFactoryBean getSsessionFactory()
     {
     	LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
     	sf.setDataSource(getDataSource());
     	Properties props = new Properties();
     	props.put("hibernate.dialect","org.hibernate.dialect.OracleDialect");
     	props.put("hibernate.hbm2ddl.auto","update");
     	props.put("hibernate.show_sql","true");
     	props.put("hibernate.format_sql","true");
     	sf.setHibernateProperties(props);
     	sf.setPackagesToScan("com.mphasis.car.entities");
     	return sf;
     	
     }
    @Bean
    public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
     
     HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
     hibernateTransactionManager.setSessionFactory(sessionFactory);
     return hibernateTransactionManager;  
   } 
     @Bean
     public AspectHelper getAspect() {
    	return new AspectHelper();
     }
     
     
     @Bean

     public WebMvcConfigurer corsConfigurer() {
          return new WebMvcConfigurerAdapter() {
        	  public void addCorsMappings(CorsRegistry registry) {                       
                         registry.addMapping("/**")
                         .allowedOrigins("*")
                         .allowedMethods("HEAD", "GET","POST","PUT","DELETE","OPTIONS")
                         //.allowedHeaders("*");
                         .allowedHeaders("Origin","X-Requested-Width","Content-Type","Accept","Access-Control-Allow-Origin");
                   }
            };
     
     
     
     
     
     }
     
}

     
     
   