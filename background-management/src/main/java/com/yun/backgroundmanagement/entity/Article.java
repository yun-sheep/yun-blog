package com.yun.backgroundmanagement.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Description 文章实体类
 * @auther j2-yizhiyang
 * @date 2023/4/30 15:15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_article")
public class Article {
    @TableId(value = "id", type = IdType.AUTO)
    /**
     * ID
     */
    private Integer id;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 文章分类ID
     */
    private Integer categoryId;
    /**
     *
     */
    private String articleCover;
    /**
     * 文章标题
     */
    private String articleTitle;
    /**
     * 文章内容
     */
    private String articleContent;
    /**
     * 文章是否顶置
     */
    private Integer isTop;

    private Integer isFeatured;
    /**
     * 文章是否删除
     */
    private Integer isDelete;
    /**
     * 文章状态：状态值 1公开 2私密 3草稿'
     */
    private Integer status;
    /**
     * 文章类型 1原创 2转载 3翻译
     */
    private Integer type;

    private String password;
    /**
     * 文章url
     */
    private String originalUrl;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;


}
