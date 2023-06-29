package com.yun.backgroundmanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yun.backgroundmanagement.domain.dto.ArticleDTO;
import com.yun.backgroundmanagement.domain.vo.ArticleInfoVO;
import com.yun.backgroundmanagement.entity.Article;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Description 文章请求服务接口
 * @auther j2-yizhiyang
 * @date 2023/5/3 15:57
 */
public interface ArticleService extends IService<Article> {
    /**
     * 上传文章图片
     *
     * @param file 文件
     * @return 文章图片地址
     */
    String saveArticleImages(MultipartFile file);

    /**
     * 添加文章
     *
     * @param article 文章
     */
    void addArticle(ArticleDTO article);
    /**
     * 删除文章
     *
     * @param articleIdList 文章id
     */
    void deleteArticle(List<Integer> articleIdList);
    /**
     * 修改文章
     *
     * @param article 文章
     */
    void updateArticle(ArticleDTO article);

    /**
     * 编辑文章
     *
     * @param articleId 文章id
     * @return 文章
     */
    ArticleInfoVO editArticle(Integer articleId);

}
