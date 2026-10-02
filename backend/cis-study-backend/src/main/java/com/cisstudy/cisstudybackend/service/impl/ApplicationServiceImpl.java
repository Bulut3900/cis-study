package com.cisstudy.cisstudybackend.service.impl;

import com.cisstudy.cisstudybackend.dto.ApplicationSubmitRequest;
import com.cisstudy.cisstudybackend.entity.Application;
import com.cisstudy.cisstudybackend.mapper.ApplicationMapper;
import com.cisstudy.cisstudybackend.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationMapper applicationMapper;

    @Override
    public void submit(ApplicationSubmitRequest request, String ipAddress) {
        Application application = new Application();

        application.setFullName(request.getFullName());
        application.setGender(request.getGender());
        application.setBirthDate(request.getBirthDate());
        application.setNationality(request.getNationality());
        application.setPassportNo(request.getPassportNo());
        application.setPhone(request.getPhone());
        application.setEmail(request.getEmail());
        application.setWechat(request.getWechat());
        application.setWhatsapp(request.getWhatsapp());
        application.setCurrentEducation(request.getCurrentEducation());
        application.setCurrentSchool(request.getCurrentSchool());
        application.setTargetSchoolId(request.getTargetSchoolId());
        application.setTargetMajor(request.getTargetMajor());
        application.setTargetDegree(request.getTargetDegree());
        application.setIntakeYear(request.getIntakeYear());
        application.setMessage(request.getMessage());

        application.setStatus("NEW");
        application.setIpAddress(ipAddress);

        applicationMapper.insert(application);

        log.info("新报名提交：{} ({})", request.getFullName(), request.getPhone());
    }
}