package com.cs6083.nanoneck.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int uid;
    private String username;
    private String password;
    private String email;
    private String city;
    private String state;

}
