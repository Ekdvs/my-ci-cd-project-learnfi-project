package com.jevigsoft.cicd.service.impl;

import com.jevigsoft.cicd.dto.user.UserReqDto;
import com.jevigsoft.cicd.entity.User;
import com.jevigsoft.cicd.enums.common.ActiveStatus;
import com.jevigsoft.cicd.exception.dto.CustomServiceException;
import com.jevigsoft.cicd.repository.UserRepository;
import com.jevigsoft.cicd.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Override
    public void addNewUser(UserReqDto userDto) {
        try {
            log.info("start method addNewUser : {}", userDto);
            User user = modelMapper.map(userDto, User.class);
            user.setCreated(new Date());
            user.setUpdated(new Date());
            user.setStatus(ActiveStatus.ACTIVE);

            userRepository.save(user);
        }catch (Exception e) {
            log.error("error : method : addNewUser", e);
            throw new CustomServiceException("Oops! Something went wrong");
        }
    }
}
