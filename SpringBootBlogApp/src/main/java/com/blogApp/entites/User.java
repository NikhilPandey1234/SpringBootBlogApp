package com.blogApp.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "userName")
    private String name;
    @Column(name = "userEmail")
    private String email;
    @Column(name = "userPassword")
    private String password;
    @Column(name = "userAbout")
    private String about;
}
