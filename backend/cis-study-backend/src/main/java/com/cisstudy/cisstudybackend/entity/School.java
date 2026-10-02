package com.cisstudy.cisstudybackend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("school")
public class School {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String nameCn;
    private String nameEn;
    private String nameRu;
    private String city;
    private String logoUrl;
    private String coverUrl;
    private String introCn;
    private String introRu;
    private String introEn;
    private Integer sort;
    private LocalDateTime createdAt;
}