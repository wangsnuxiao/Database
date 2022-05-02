package com.cs6083.nanoneck.User.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {
    private int uid;
    private String username;
    private String password;
    private String email;
    private String city;
    private String state;
}
