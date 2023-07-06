package com.yun.backgroundmanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yun.backgroundmanagement.domain.vo.CategoryBackVO;
import com.yun.backgroundmanagement.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description 文章分类Mapper
 * @auther j2-yizhiyang
 * @date 2023/5/3 16:23
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
    /**
    * @description: 查询后台分类列表
     * @param keyword 关键字
     * @param limit 页码
     * @param size 大小
    * @return
    * @author yun
    * @date 2023/7/5
    */
    List<CategoryBackVO> selectCategory(@Param("limit") Long limit,
                                        @Param("size") Long size,
                                        @Param("keyword") String keyword);
}
