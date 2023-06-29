package com.yun.foregroundmanagement.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Description 相册实体类
 * @auther j2-yizhiyang
 * @date 2023/4/30 17:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(value = "t_photo_album")
public class PhotosAlbum {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 相册名称
     */
    private String albumName;
    /**
     * 相册描述
     */
    private String albumDesc;
    /**
     * 相册封面
     */
    private String albumCover;
    /**
     * 是否删除
     */
    private Integer isDelete;
    /**
     * 相册状态：1公开 2私密'
     */
    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
}
