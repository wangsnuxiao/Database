package com.cs6083.nanoneck.User.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class answer {
    private String username;
    private int aid;
    private  int uid;
    private int qid;
    private String answer_text;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date answer_created_time;
    private int thumbs_up_num;
}
