package com.jevigsoft.cicd.controller;

import com.jevigsoft.cicd.dto.common.CommonResponse;
import com.jevigsoft.cicd.dto.user.UserReqDto;
import com.jevigsoft.cicd.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
@Log4j2
public class UserController {


    private final UserService userService;

    @PostMapping()
    public ResponseEntity<?> addNewUser(@RequestBody UserReqDto userReqDto) {
        userService.addNewUser(userReqDto);
        return ResponseEntity.ok(new CommonResponse<>(true, "User added successfully"));
    }

}
