package com.cisstudy.cisstudybackend.service;

import com.cisstudy.cisstudybackend.dto.ApplicationSubmitRequest;

public interface ApplicationService {

    /**
     * 提交报名
     * @param request 报名信息
     * @param ipAddress 提交者 IP
     */
    void submit(ApplicationSubmitRequest request, String ipAddress);
}