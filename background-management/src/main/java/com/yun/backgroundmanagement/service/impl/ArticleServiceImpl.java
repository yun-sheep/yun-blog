package com.yun.backgroundmanagement.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yun.backgroundmanagement.common.strategy.context.UploadStrategyContext;
import com.yun.backgroundmanagement.domain.dto.ArticleDTO;
import com.yun.backgroundmanagement.domain.vo.ArticleInfoVO;
import com.yun.backgroundmanagement.entity.Article;
import com.yun.backgroundmanagement.entity.Category;
import com.yun.backgroundmanagement.mapper.ArticleMapper;
import com.yun.backgroundmanagement.mapper.CategoryMapper;
import com.yun.backgroundmanagement.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

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
    @Autowired
    private CategoryMapper categoryMapper;
    /**
     * 上传文章图片
     *
     * @param file 文件
     * @return 文章图片地址
     */
    @Override
    public String saveArticleImages(MultipartFile file) {
        // 上传文件
        String url = uploadStrategyContext.executeUploadStrategy(file, ARTICLE.getPath());
        return url;
    }
    /**
    * @description: 添加文章
    * @param articledto 需要添加的文章
    * @return void
    * @author yun
    * @date 2023/7/5
    */
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
    /**
     * 删除文章
     *
     * @param articleIdList
     */
    @Override
    public void deleteArticle(List<Integer> articleIdList) {
        //

    }

    @Override
    public void updateArticle(ArticleDTO article) {

    }
    /**
     * 删除文章
     *
     * @param articleId 文章ID
     */
    @Override
    public ArticleInfoVO editArticle(Integer articleId) {
        return null;
    }
    /**
    * @description: 保存文章分类
    * @param
    * @return
    * @author yun
    * @date 2023/7/5
    */
    private Integer saveArticleCategory(ArticleDTO articleDTO){
        //查询分类(分类名建一个索引)
        Category category =  categoryMapper.selectOne(new LambdaQueryWrapper<Category>()
                .select(Category::getCategoryName)
                .eq(Category::getCategoryName,articleDTO.getCategoryName()));
                articleDTO.getCategoryName();
        //分类不存在（保存分类）
        //if(Objects.isNull(category)){}
        return null;


    }
}
