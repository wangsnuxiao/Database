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
                + "from Questions join User on User.uid = Questions.uid join Topics on Topics.tid = Questions.tid "
                +" Order by Questions.question_created_time desc ";
        return  jdbcTemplate.queryForList(query);
    }
    public List<Map<String,Object>> listCurrentAnswers(int qid){
        String query = "Select Answers.*, User.username "
                + "from Questions join Answers on Questions.qid = Answers.qid  " +
                "join User on User.uid = Answers.uid " +
                "join Topics on Topics.tid = Questions.tid "
                + "Where Questions.qid = "+qid
                +" Order by thumbs_up_num desc ";

        return jdbcTemplate.queryForList(query);

    }

    public List<Map<String,Object>> listAlgorithmQuestions(){
        String query = "Select * "
                + "from Questions join User on User.uid = Questions.uid join Topics on Topics.tid = Questions.tid "
                + "where Questions.tid = 5"
                +" Order by Questions.question_created_time desc ";
        return  jdbcTemplate.queryForList(query);
    }
    public List<Map<String,Object>> listDbDesignQuestions(){
        String query = "Select * "
                + "from Questions join User on User.uid = Questions.uid join Topics on Topics.tid = Questions.tid "
                + "where Questions.tid = 6"
                +" Order by Questions.question_created_time desc ";
        return  jdbcTemplate.queryForList(query);
    }
    public List<Map<String,Object>> listProgrammingLanguageQuestions(){
        String query = "Select * "
                + "from Questions join User on User.uid = Questions.uid join Topics on Topics.tid = Questions.tid "
                + "where Questions.tid = 2"
                +" Order by Questions.question_created_time desc ";
        return  jdbcTemplate.queryForList(query);
    }
    public List<Map<String,Object>> listPaintQuestions(){
        String query = "Select * "
                + "from Questions join User on User.uid = Questions.uid join Topics on Topics.tid = Questions.tid "
                + "where Questions.tid = 7"
                +" Order by Questions.question_created_time desc ";
        return  jdbcTemplate.queryForList(query);
    }
}
