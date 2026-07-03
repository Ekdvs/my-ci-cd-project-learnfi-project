package com.jevigsoft.cicd.service;

import com.jevigsoft.cicd.dto.user.UserReqDto;

public interface UserService {

    void addNewUser(UserReqDto user);
}
