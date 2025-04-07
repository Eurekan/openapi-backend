package com.eureka.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eureka.project.model.entity.UserInterfaceInfo;
import com.eureka.project.service.UserInterfaceInfoService;
import com.eureka.project.mapper.UserInterfaceInfoMapper;
import org.springframework.stereotype.Service;

@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService{

}




