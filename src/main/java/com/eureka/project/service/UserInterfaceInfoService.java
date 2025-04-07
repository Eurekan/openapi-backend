package com.eureka.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eureka.project.model.entity.UserInterfaceInfo;

public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    /**
     * 校验用户接口信息
     *
     * @param userInterfaceInfo 用户接口信息
     * @param add               是否成功
     */
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);
}
