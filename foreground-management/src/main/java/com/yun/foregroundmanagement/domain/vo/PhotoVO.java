package com.yun.foregroundmanagement.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description 照片VO
 * @auther j2-yizhiyang
 * @date 2023/5/2 12:07
 */
@Data
@ApiModel(description = "照片VO")
public class PhotoVO {
    /**
     * 照片id
     */
    @ApiModelProperty(value = "照片id")
    private Integer id;

    /**
     * 照片链接
     */
    @ApiModelProperty(value = "照片链接")
    private String photoUrl;
}
