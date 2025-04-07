package com.eureka.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.eureka.project.model.entity.UserInterfaceInfo;

public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    /**
     * 校验用户接口信息
     *
     * @param userInterfaceInfo 用户接口信息
     * @param add               是否新增
     */
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    /**
     * 统计调用次数
     *
     * @param interfaceInfoId 接口信息 id
     * @param userId          用户 id
     * @return 是否成功
     */
    boolean invokeCount(long interfaceInfoId, long userId);
}
