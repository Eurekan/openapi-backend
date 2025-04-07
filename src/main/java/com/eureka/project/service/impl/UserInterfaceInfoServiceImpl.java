package com.eureka.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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

    /**
     * 统计调用次数
     *
     * @param interfaceInfoId 接口信息 id
     * @param userId          用户 id
     * @return 是否成功
     */
    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        // 校验参数
        if (interfaceInfoId <= 0 || userId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 构造查询条件
        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper
                .eq("interfaceInfoId", interfaceInfoId)
                .eq("userId", userId)
                .setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");
        return this.update(updateWrapper);
    }

}




