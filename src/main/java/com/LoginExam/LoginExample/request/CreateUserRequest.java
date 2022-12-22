package com.LoginExam.LoginExample.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class CreateUserRequest {
    @NotEmpty
    @Size(min = 2, message = "Kullanıcı 2 karakterden fazla olmalı")
    private String userName;
    @NotEmpty
    @Size(min = 2 ,message = "Şifre 2 karakterden fazla olmalı")
    private String password;
}
