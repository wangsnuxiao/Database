package com.cs6083.nanoneck.User.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class question implements Serializable {
    //question id
    private int qid;
    //topic id
    private int tid;
    private int uid;
    private String qTitle;
    private String qBody;

    private  String username;
    private String tname;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date question_created_time;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date question_solved_time;
    private  int bestAnswer;

}




