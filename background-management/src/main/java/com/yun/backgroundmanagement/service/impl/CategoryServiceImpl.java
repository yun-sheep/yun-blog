package com.yun.backgroundmanagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yun.backgroundmanagement.entity.Category;
import com.yun.backgroundmanagement.mapper.CategoryMapper;
import com.yun.backgroundmanagement.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @auther j2-yizhiyang
 * @date 2023/5/3 16:27
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
        implements CategoryService {
}
