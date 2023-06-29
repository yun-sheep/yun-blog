package com.yun.backgroundmanagement.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Description
 * @auther j2-yizhiyang
 * @date 2023/4/30 17:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(value = "t_photo")
public class Photos {
    @TableId(type = IdType.AUTO)
    /**
     * id
     */
    private Integer id;
    /**
     * 相册id
     */
    private Integer albumId;
    /**
     * 照片名称
     */
    private String photoName;
    /**
     * 照片描述
     */
    private String photoDesc;
    /**
     * 照片地址
     */
    private String photoSrc;

    private Integer isDelete;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
}
