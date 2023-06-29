package com.yun.backgroundmanagement.controller;

import com.yun.backgroundmanagement.domain.PageResult;
import com.yun.backgroundmanagement.domain.dto.ArticleDTO;
import com.yun.backgroundmanagement.domain.dto.ConditionDTO;
import com.yun.backgroundmanagement.domain.vo.ArticleBackVO;
import com.yun.backgroundmanagement.domain.vo.ArticleInfoVO;
import com.yun.backgroundmanagement.domain.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Description 后台文章管理模块
 * @auther j2-yizhiyang
 * @date 2023/5/2 12:11
 */
@Api(tags = "后台文章模块")
@RestController
public class ArticleController {

    /**
     * 上传文章图片
     *
     * @param file 文件
     * @return {@link ResultVO<String>} 文章图片地址
     */
    @ApiOperation(value = "添加文章")
    //SaCheckPermission("blog:article:add")(认证授权来做的）
    @PostMapping("/admin/article/add")
    public ResultVO<String> addArticle(@RequestParam("file") MultipartFile file) {
        return null;
    }

    /**
     * 添加文章
     *
     * @param article 文章信息
     * @return {@link ResultVO<?>}
     */
    @ApiOperation(value = "添加文章")
    public ResultVO<?> addArticle(@Validated @RequestBody ArticleDTO article) {
        return ResultVO.ok();
    }
    /**
     * 删除文章
     *
     * @param articleIdList 文章id集合
     * @return {@link ResultVO<>}
     */
    @DeleteMapping("/admin/article/delete")
    public ResultVO<?> deleteArticle(@RequestBody List<Integer> articleIdList) {
        //articleService.deleteArticle(articleIdList);
        return ResultVO.ok();
    }
    /**
     * 修改文章
     *
     * @param article 文章信息
     * @return {@link ResultVO<>}
     */
    @ApiOperation(value = "修改文章")
    @PutMapping("/admin/article/update")
    public ResultVO<?> updateArticle(@Validated @RequestBody ArticleDTO article) {
        //articleService.updateArticle(article);
        return ResultVO.ok();
    }
    /**
     * 编辑文章
     *
     * @param articleId 文章id
     * @return {@link ResultVO<ArticleInfoVO>} 后台文章
     */
    @ApiOperation(value = "编辑文章")
    @GetMapping("/admin/article/edit/{articleId}")
    public ResultVO<ArticleInfoVO> editArticle(@PathVariable("articleId") Integer articleId) {
        //return ResultVO.success(articleService.editArticle(articleId));
        return null;
    }
    /**
     * 查看后台文章列表
     *
     * @param condition 条件
     * @return {@link ResultVO<ArticleBackVO>} 后台文章列表
     */
    public ResultVO<PageResult<ArticleBackVO>> listArticleBackVO(ConditionDTO condition){
        return  null;
    }


}
