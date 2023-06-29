package com.yun.backgroundmanagement.service.impl;

import com.yun.backgroundmanagement.common.strategy.context.UploadStrategyContext;
import com.yun.backgroundmanagement.common.utils.FileUtils;
import com.yun.backgroundmanagement.service.PhotoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.yun.backgroundmanagement.common.enums.FilePathEnum.PHOTO;

/**
 * @Description
 * @auther j2-yizhiyang
 * @date 2023/5/3 15:00
 */
@Service
@Slf4j
public class PhotoServiceImpl implements PhotoService{
    @Autowired
    private UploadStrategyContext uploadStrategyContext;

    public String uploadPhoto(MultipartFile file) {
        //上传照片文件
        String url = uploadStrategyContext.executeUploadStrategy(file, PHOTO.getPath());
        try{
            //获取md5值
            String md5 = FileUtils.getMd5(file.getInputStream());
            //获取文件扩展名
            String extName = FileUtils.getExtension(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //TODO 把url插入到相应的blog
        return url;
    }
}
