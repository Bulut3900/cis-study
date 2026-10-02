package com.cisstudy.cisstudybackend.controller;

import com.cisstudy.cisstudybackend.common.Result;
import com.cisstudy.cisstudybackend.dto.ApplicationSubmitRequest;
import com.cisstudy.cisstudybackend.service.ApplicationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/application")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    /**
     * 提交报名
     * POST /api/application/submit
     */
    @PostMapping("/submit")
    public Result<Void> submit(@Valid @RequestBody ApplicationSubmitRequest request,
                               HttpServletRequest httpRequest) {
        // 获取客户端 IP
        String ipAddress = getClientIp(httpRequest);
        applicationService.submit(request, ipAddress);
        return Result.success();
    }

    /**
     * 获取客户端真实 IP
     */
    private String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}