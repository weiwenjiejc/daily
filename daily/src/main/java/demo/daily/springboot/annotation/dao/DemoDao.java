package demo.daily.springboot.annotation.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DemoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public String mysqlVersion() {
		
		String sql = "select version()";
		jdbcTemplate.execute(sql);
		
		
	}
}
