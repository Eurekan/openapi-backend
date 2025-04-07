package com.eureka.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eureka.project.common.ErrorCode;
import com.eureka.project.exception.BusinessException;
import com.eureka.project.mapper.UserInterfaceInfoMapper;
import com.eureka.project.model.entity.UserInterfaceInfo;
import com.eureka.project.service.UserInterfaceInfoService;
import org.springframework.stereotype.Service;

@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
        implements UserInterfaceInfoService {

    /**
     * 校验用户接口信息
     *
     * @param userInterfaceInfo 用户接口信息
     * @param add               是否新增
     */
    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        // 校验参数
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 校验操作
        if (add) {
            if (userInterfaceInfo.getUserId() == null || userInterfaceInfo.getInterfaceInfoId() == null) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口或用户不存在");
            }
            if (userInterfaceInfo.getLeftNum() < 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口剩余调用次数不能小于0");
            }
        }
    }

}




