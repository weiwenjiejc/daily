package org.wwj.demo.annotation.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class DemoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String mysqlVersion() {

        String sql = "select version() as version";
        List<Map<String, Object>> query = jdbcTemplate.queryForList(sql);
        Map<String, Object> objectMap = query.get(0);
        String version = (String) objectMap.get("version");
        return version;

    }
}
