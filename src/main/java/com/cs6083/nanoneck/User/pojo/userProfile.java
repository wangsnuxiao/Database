package com.cs6083.nanoneck.User.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class userProfile {
	private String username;
	private String email;
	private int age;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_of_birth;
	private String description;
	private String level;
	private int total_thumbs_up;
	private int visibility;
	private String state;
	private String city;

}
