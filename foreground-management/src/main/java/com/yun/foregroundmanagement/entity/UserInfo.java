package com.yun.foregroundmanagement.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Description 用户信息
 * @auther j2-yizhiyang
 * @date 2023/4/30 16:14
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user_info")
public class UserInfo {
    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户email
     */
    private String email;
    /**
     * 用户昵称
     */
    private String nickname;

    private String avatar;
    /**
     * 用户介绍
     */
    private String intro;

    private String website;

    private Integer isSubscribe;

    private Integer isDisable;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
}
