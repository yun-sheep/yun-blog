package com.yun.backgroundmanagement.controller;

import com.yun.backgroundmanagement.domain.vo.ResultVO;
import com.yun.backgroundmanagement.service.impl.PhotoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description 后台图片请求处理模块
 * @auther j2-yizhiyang
 * @date 2023/5/3 14:57
 */
@Api(tags = "照片模块")
@RestController
public class PhotosController {
    @Autowired
    private PhotoServiceImpl photoService;
    /**
     * 上传照片
     *
     * @param file 文件
     * @return {@link ResultVO<String>} 照片地址
     */
    @ApiOperation(value = "上传照片")
    @ApiImplicitParam(name = "file", value = "照片", required = true, dataType = "MultipartFile")
    @PostMapping("/admin/photo/upload")
    public ResultVO<String> uploadPhoto(@RequestParam("file") MultipartFile file) {
        //return Result.success(photoService.uploadPhoto(file));
        String url = photoService.uploadPhoto(file);
        return ResultVO.ok(url);
    }

}
