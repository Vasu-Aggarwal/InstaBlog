package com.InstaBlog.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserDto {

    private int id;

    @NotNull
    @NotEmpty
    @Size(min = 4, message = "Name must be minimum 4 characters")
    private String name;
    @Email(message = "Email is invalid")
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    private String password;
    @NotNull
    @NotEmpty
    private String about;

}
