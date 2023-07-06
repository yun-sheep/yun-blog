package com.yun.backgroundmanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 文章标签Mapper
 * @auther j2-yizhiyang
 * @date 2023/5/3 17:21
 */
@Service
public interface ArticleTagMapper extends BaseMapper<ArticleTagMapper> {
    /**
    * @description:批量保存文章
    * @param tagIdList 文章对应的tag
    * @param articleId 文章ID
    * @return
    * @author yun
    * @date 2023/7/5
    */
    void saveBatchArticleTag(@Param("articleId") Integer articleId, List<Integer> tagIdList);
}
