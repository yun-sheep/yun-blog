package com.yun.backgroundmanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.yun.backgroundmanagement.entity.Tags;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description
 * @auther j2-yizhiyang
 * @date 2023/5/3 16:24
 */
@Mapper
public interface TagsMapper extends BaseMapper<Tags> {
    /**
    * @description: 根据tage名查询tags
    * @param tagNameList tags名称
    * @return tags列表
    * @author yun
    * @date 2023/7/6
    */
    //TODO 未实现具体实现函数
    List<Tags> selectTagList(List<String> tagNameList);
}
