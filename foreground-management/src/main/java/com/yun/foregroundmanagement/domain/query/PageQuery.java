package com.yun.foregroundmanagement.domain.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.Min;

/**
 * @Description 分页查询父对象
 * @auther j2-yizhiyang
 * @date 2023/5/2 12:00
 */
@Getter
@Setter
@ToString
public class PageQuery {
    @Min(value = 1, message = "页码最小值为1")
    @ApiModelProperty(value = "查询页码", example = "1")
    private long pageIndex;
    @Min(value = 1, message = "条数最小值为1")
    @ApiModelProperty(value = "查询条数", example = "10")
    private long pageSize;
}
