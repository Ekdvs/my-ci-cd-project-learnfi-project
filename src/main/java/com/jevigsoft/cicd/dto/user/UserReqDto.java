package com.jevigsoft.cicd.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReqDto {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String mobile;
}
