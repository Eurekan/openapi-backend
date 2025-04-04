package com.eureka.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eureka.project.common.ErrorCode;
import com.eureka.project.exception.BusinessException;
import com.eureka.project.model.entity.InterfaceInfo;
import com.eureka.project.service.InterfaceInfoService;
import com.eureka.project.mapper.InterfaceInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService{

    /**
     * 校验接口信息
     * @param interfaceInfo 接口信息
     * @param add 是否成功
     */
    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        // 判断接口信息对象是否为空,为空则抛出参数错误的异常
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 获取接口信息对象的名称
        String name = interfaceInfo.getName();

        // 如果是添加操作,所有参数必须非空,否则抛出参数错误的异常
        if (add) {
            if (StringUtils.isAnyBlank(name)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        // 如果接口名称不为空且长度大于50,抛出参数错误的异常,错误信息为"名称过长"
        // 本期写成<50,(没有解决),第二期视频中解决了
        if (StringUtils.isNotBlank(name) && name.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "名称过长");
        }
    }
}




