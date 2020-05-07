package kun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "kun")
public class PersistanceConfig {
	
	@Bean(name = "hkds")
	public HikariDataSource createDS() {
		HikariDataSource hkds=new HikariDataSource();
		hkds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hkds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE");
		hkds.setUsername("sharath");
		hkds.setPassword("sharath1234");
		return hkds;
	}

	@Bean(name = "jTemp")
	public JdbcTemplate createJT() {
		JdbcTemplate jTemp=new JdbcTemplate();
		jTemp.setDataSource(createDS());
		return jTemp;
	}
}
