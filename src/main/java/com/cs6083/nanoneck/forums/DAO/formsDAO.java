package com.cs6083.nanoneck.forums.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository

public class formsDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Map<String,Object>> listAllQuestions(){
        String query = "Select * " + "from Questions";
        return  jdbcTemplate.queryForList(query);
    }
}
