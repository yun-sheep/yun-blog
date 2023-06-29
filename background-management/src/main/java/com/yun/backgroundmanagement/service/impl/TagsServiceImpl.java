package com.yun.backgroundmanagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yun.backgroundmanagement.entity.Tags;
import com.yun.backgroundmanagement.mapper.TagsMapper;
import com.yun.backgroundmanagement.service.TagsService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @auther j2-yizhiyang
 * @date 2023/5/3 16:27
 */
@Service
public class TagsServiceImpl extends ServiceImpl<TagsMapper, Tags> implements TagsService {
}
