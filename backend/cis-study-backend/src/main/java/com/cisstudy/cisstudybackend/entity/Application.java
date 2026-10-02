package com.cisstudy.cisstudybackend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@TableName("application")
public class Application {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String fullName;
    private String gender;
    private LocalDate birthDate;
    private String nationality;
    private String passportNo;
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
    private String status;
    private String remark;
    private String ipAddress;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}