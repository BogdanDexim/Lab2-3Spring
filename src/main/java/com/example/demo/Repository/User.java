package com.example.demo.Repository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class User {
    private int userId;
    private String username;
    private String password;
    private boolean adminrights;
}
