package com.eureka.project.service;

import com.eureka.project.model.entity.InterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

public interface InterfaceInfoService extends IService<InterfaceInfo> {

    /**
     * 校验接口信息
     * @param interfaceInfo 接口信息
     * @param add 是否成功
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
