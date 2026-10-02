package com.cisstudy.cisstudybackend.controller;

import com.cisstudy.cisstudybackend.common.Result;
import com.cisstudy.cisstudybackend.entity.School;
import com.cisstudy.cisstudybackend.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/school")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    /**
     * 查询所有学校
     * GET /api/school/list
     */
    @GetMapping("/list")
    public Result<List<School>> list() {
        return Result.success(schoolService.listAll());
    }

    /**
     * 查询学校详情
     * GET /api/school/{id}
     */
    @GetMapping("/{id}")
    public Result<School> detail(@PathVariable Long id) {
        return Result.success(schoolService.getById(id));
    }
}