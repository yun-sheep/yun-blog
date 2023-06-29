package com.yun.backgroundmanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.yun.backgroundmanagement.entity.Tags;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description
 * @auther j2-yizhiyang
 * @date 2023/5/3 16:24
 */
@Mapper
public interface TagsMapper extends BaseMapper<Tags> {
}
