package com.yun.backgroundmanagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yun.backgroundmanagement.common.strategy.context.UploadStrategyContext;
import com.yun.backgroundmanagement.entity.Photos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description
 * @auther j2-yizhiyang
 * @date 2023/5/3 15:00
 */
public interface PhotoService {
    public String uploadPhoto(MultipartFile file);
}
