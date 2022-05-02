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
        String query = "Select * "
                + "from Questions join User on User.uid = Questions.uid join Topics on Topics.tid = Questions.tid"
                +" Order by Questions.question_created_time desc ";
        return  jdbcTemplate.queryForList(query);
    }
}
