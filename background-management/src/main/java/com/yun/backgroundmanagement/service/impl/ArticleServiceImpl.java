package com.yun.backgroundmanagement.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yun.backgroundmanagement.common.strategy.context.UploadStrategyContext;
import com.yun.backgroundmanagement.domain.dto.ArticleDTO;
import com.yun.backgroundmanagement.domain.vo.ArticleInfoVO;
import com.yun.backgroundmanagement.entity.Article;
import com.yun.backgroundmanagement.mapper.ArticleMapper;
import com.yun.backgroundmanagement.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.yun.backgroundmanagement.common.enums.FilePathEnum.ARTICLE;

/**
 * @Description 文章操作实现类
 * @auther j2-yizhiyang
 * @date 2023/5/3 15:58
 */
@Service
@Slf4j
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper,Article> implements ArticleService {
    @Autowired
    private UploadStrategyContext uploadStrategyContext;
    @Override
    public String saveArticleImages(MultipartFile file) {
        // 上传文件
        String url = uploadStrategyContext.executeUploadStrategy(file, ARTICLE.getPath());
        return url;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addArticle(ArticleDTO articledto) {
        //保存文章分类
        Integer categoryId = 1;
        // 添加文章
        Article newArticle = BeanUtil.copyProperties(articledto,Article.class);
        //是否有缩略图
        if(StringUtils.isEmpty(newArticle.getArticleCover())){
            String s = "有";
        }
        newArticle.setCategoryId(categoryId);
        baseMapper.insert(newArticle);
        //保存文章标签（文章标签和分类都提前写在redis中）


    }

    @Override
    public void deleteArticle(List<Integer> articleIdList) {

    }

    @Override
    public void updateArticle(ArticleDTO article) {

    }

    @Override
    public ArticleInfoVO editArticle(Integer articleId) {
        return null;
    }
}
