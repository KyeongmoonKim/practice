package config08;

import chap08.spring.*;

 
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.*;
//import javax.naming.*;
//import javax.sql.*;

@Configuration
public class AppCtx {
	
	@Bean(destroyMethod = "close") 
	public DataSource dataSource(){ //DataSource Bean
		DataSource ds = new DataSource();
		ds.setDriverClassName("oracle.jdbc.OracleDriver"); //context.xml의 내용
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE"); //context.xml의내용
		ds.setUsername("scott");
		ds.setPassword("tiger");
		ds.setInitialSize(2);
		ds.setMaxActive(50); //max active 와 maxidle은 같은숫자로
		ds.setMaxIdle(50);
		return ds;
	}
	
	@Bean
	public UserDao userDao(){
		return new UserDao(dataSource());
	}
}
