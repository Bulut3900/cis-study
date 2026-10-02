package com.cisstudy.cisstudybackend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ApplicationSubmitRequest {

    @NotBlank(message = "姓名不能为空")
    private String fullName;

    private String gender;
    private LocalDate birthDate;

    @NotBlank(message = "国籍不能为空")
    private String nationality;

    private String passportNo;

    @NotBlank(message = "电话不能为空")
    private String phone;

    private String email;
    private String wechat;
    private String whatsapp;

    private String currentEducation;
    private String currentSchool;

    private Long targetSchoolId;
    private String targetMajor;
    private String targetDegree;
    private String intakeYear;

    private String message;
}