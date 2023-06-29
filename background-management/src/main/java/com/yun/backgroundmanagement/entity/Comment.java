package com.yun.backgroundmanagement.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Description 评论实体类
 * @auther j2-yizhiyang
 * @date 2023/4/30 16:40
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_comment")
public class Comment {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 评论用户id
     */
    private Integer userId;
    /**
     * 回复用户id
     */
    private Integer replyUserId;
    /**
     * 评论主题ID
     */
    private Integer topicId;
    /**
     * 评论内容
     */
    private String commentContent;
    /**
     * 父评论id
     */
    private Integer parentId;
    /**
     * 评论类型：1.文章 2.留言 3.关于我 4.友链 5.说说
     */
    private Integer type;

    private Integer isDelete;

    private Integer isReview;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
}
