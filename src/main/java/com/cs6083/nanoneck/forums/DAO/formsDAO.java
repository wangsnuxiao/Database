package com.cs6083.nanoneck.forums.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
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
    public List<Map<String,Object>> listCurrentAnswers(int qid){
        String query = "Select * "
                + "from Questions join Answers on Questions.qid = Answers.qid join User on User.uid = Questions.uid join Topics on Topics.tid = Questions.tid"
                + "Where Questions.qid = :questionId"
                +" Order by thumbs_up_num desc ";
        return  jdbcTemplate.queryForList(
                query,
        new MapSqlParameterSource().addValue("questionId", qid));

    }
}
