package com.cisstudy.cisstudybackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cisstudy.cisstudybackend.common.BusinessException;
import com.cisstudy.cisstudybackend.entity.School;
import com.cisstudy.cisstudybackend.mapper.SchoolMapper;
import com.cisstudy.cisstudybackend.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final SchoolMapper schoolMapper;

    @Override
    public List<School> listAll() {
        LambdaQueryWrapper<School> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByAsc(School::getSort);
        return schoolMapper.selectList(wrapper);
    }

    @Override
    public School getById(Long id) {
        School school = schoolMapper.selectById(id);
        if (school == null) {
            throw new BusinessException("学校不存在");
        }
        return school;
    }
}