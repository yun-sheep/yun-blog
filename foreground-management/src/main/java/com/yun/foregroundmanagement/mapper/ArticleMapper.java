package com.yun.foregroundmanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yun.foregroundmanagement.domain.query.PageQuery;
import com.yun.foregroundmanagement.domain.vo.ArticleHomeVO;
import com.yun.foregroundmanagement.domain.vo.ArticleInfoVO;
import com.yun.foregroundmanagement.domain.vo.ArticleVO;
import com.yun.foregroundmanagement.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @auther j2-yizhiyang
 * @date 2023/5/2 11:53
 */
public interface ArticleMapper extends BaseMapper<Article> {
    /**
     * 根据id查询文章信息
     *
     * @param articleId 文章id
     * @return 文章信息
     */
    ArticleInfoVO selectArticleInfoById(@Param("articleId") Integer articleId);
    /**
     * 查询首页文章
     *
     * @param  ArticleHomepageQuery 分页查询
     * @return 首页文章
     */
    List<ArticleHomeVO> selectArticleHomeList(PageQuery ArticleHomepageQuery);
    /**
     * 根据id查询首页文章
     *
     * @param articleId 文章id
     * @return 首页文章
     */
    ArticleVO selectArticleHomeById(Integer articleId);
}
