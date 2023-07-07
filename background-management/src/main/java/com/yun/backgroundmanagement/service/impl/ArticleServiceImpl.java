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
import com.yun.backgroundmanagement.entity.Tags;
import com.yun.backgroundmanagement.mapper.ArticleMapper;
import com.yun.backgroundmanagement.mapper.ArticleTagMapper;
import com.yun.backgroundmanagement.mapper.CategoryMapper;
import com.yun.backgroundmanagement.mapper.TagsMapper;
import com.yun.backgroundmanagement.service.ArticleService;
import com.yun.backgroundmanagement.service.TagsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
    @Autowired
    private TagsMapper tagsMapper;
    @Autowired
    private TagsService tagsService;
    @Autowired
    private ArticleTagMapper articleTagMapper;
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
        //保存文章分裂
        Integer categoryId = saveArticleCategory(articledto);
        // 添加文章
        Article newArticle = BeanUtil.copyProperties(articledto,Article.class);
        //是否有缩略图
        if(StringUtils.isEmpty(newArticle.getArticleCover())){
            String s = "有";
        }
        newArticle.setCategoryId(categoryId);
        baseMapper.insert(newArticle);
        //保存文章标签
        saveArticleTag(articledto, newArticle.getId());

    }
    /**
    * @description: 删除文章
    * @param  articleIdList 待删除文章列表
    * @return void
    * @author yun
    * @date 2023/7/6
    */
    @Override
    public void deleteArticle(List<Integer> articleIdList) {
        //

    }
    /**
    * @description: 更新文章
    * @param article 更新的文章
    * @return void
    * @author yun
    * @date 2023/7/6
    */
    @Override
    public void updateArticle(ArticleDTO article) {

    }
    /**
    * @description: 修改文章
    * @param articleId 文章id
    * @return com.yun.backgroundmanagement.domain.vo.ArticleInfoVO
    * @author yun
    * @date 2023/7/6
    */
    @Override
    public ArticleInfoVO editArticle(Integer articleId) {
        return null;
    }
    /**
    * @description: 保存文章分类
    * @param articleDTO 要保存的文章
    * @return 文章分类对应的ID
    * @author yun
    * @date 2023/7/5
    */
    private Integer saveArticleCategory(ArticleDTO articleDTO){
        //查询分类(分类名建一个索引)
        Category category =  categoryMapper.selectOne(new LambdaQueryWrapper<Category>()
                .select(Category::getCategoryName)
                .eq(Category::getCategoryName,articleDTO.getCategoryName()));
        //TODO 文章分类目前只保存了一个
        //分类不存在（保存分类）
        if(Objects.isNull(category)){
            category = Category.builder()
                    .categoryName(articleDTO.getCategoryName())
                    .build();
            //保存分类
            categoryMapper.insert(category);
        }
        return category.getId();


    }
    /**
    * @description:  保存文章标签
    * @param articleDTO
     * @param articleID  文章标签
    * @return void
    * @author yun
    * @date 2023/7/6
    */
    private void saveArticleTag(ArticleDTO articleDTO,Integer articleID){

        //获取文章标签列表
        List<String> tagsNameList  = articleDTO.getTagNameList();
        if(CollectionUtils.isNotEmpty(tagsNameList)){
            //查询出已经存在的标签
            List<Tags> existTagList = tagsMapper.selectTagList(tagsNameList);
            List<String> existTagNameList = existTagList.stream()
                    .map(Tags::getTagName)
                    .collect(Collectors.toList());
            List<Integer> existTagIntegerList = existTagList.stream()
                    .map(Tags::getId)
                    .collect(Collectors.toList());
            //移除已经存在的标签列表
            tagsNameList.removeAll(existTagNameList);
            //含有新标签
            if(CollectionUtils.isNotEmpty(tagsNameList)){
                //新标签列表
                List<Tags> newTagList = tagsNameList.stream()
                        .map(tag->Tags.builder().tagName(tag).build())
                        .collect(Collectors.toList());
                //批量保存新标签
                tagsService.saveBatch(newTagList);
                //获取新标签id列表
                List<Integer> newTagIdList = newTagList.stream()
                        .map(Tags::getId)
                        .collect(Collectors.toList());
                //新标签id添加到id列表
                existTagIntegerList.addAll(newTagIdList);
            }
            //添加到文章-标签关联表
            articleTagMapper.saveBatchArticleTag(articleID,existTagIntegerList);

        }

    }

}
