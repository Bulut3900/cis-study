package com.cisstudy.cisstudybackend.service;

import com.cisstudy.cisstudybackend.entity.School;

import java.util.List;

public interface SchoolService {

    /**
     * 查询所有学校（按 sort 排序）
     */
    List<School> listAll();

    /**
     * 根据 ID 查询学校详情
     */
    School getById(Long id);
}