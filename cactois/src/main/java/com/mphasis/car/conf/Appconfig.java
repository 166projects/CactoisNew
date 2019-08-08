package com.mphasis.car.conf;
import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.mphasis.car")
@EnableAspectJAutoProxy
//@EnableTransactionManagement
public class Appconfig {
      
     @Bean
     public DriverManagerDataSource getDataSource()
     {
     	DriverManagerDataSource ds = new DriverManagerDataSource();
     	ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
     	ds.setUrl("jdbc:oracle:thin:@10.96.177.149:1521:xe");
     ds.setUsername("cacatois");
     	ds.setPassword("12345");
     	return ds;
     	
     }
     @Bean
     public LocalSessionFactoryBean getSessionFactory()
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
     public WebMvcConfigurerAdapter corsConfigurer() {
      
      return new WebMvcConfigurerAdapter() {
       
       public void addCorsMappings(CorsRegistry registry) {
        
        registry.addMapping("/**")
        .allowedOrigins("*").allowedMethods("HEAD", "GET","POST","PUT","DELETE").allowedHeaders("*");
          //  .allowedHeaders("Access-Control-Allow-Origin","Origin","X-Requested-Width","Content-Type","Accept");
       }
      };
     }
     
}

