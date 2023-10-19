package com.blogApp.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private int id;

    @NotEmpty
    @Size(min = 4, message = "Username must be min of 4 characters")
    private String name;

    @Email(message = "Email address is not valid!!")
    private String email;

    @NotEmpty(message = "Please fill the password")
    @Size(min = 3, max = 10, message = "Password must be of 3 chars and max of 10 chars!!")
    private String password;

    @NotEmpty(message = "Please fill this column")
    private String about;
}
