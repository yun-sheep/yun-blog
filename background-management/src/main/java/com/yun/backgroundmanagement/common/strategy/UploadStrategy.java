package com.yun.backgroundmanagement.common.strategy;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Description 图片上传策略
 * @auther j2-yizhiyang
 * @date 2023/5/2 15:20
 */
public interface UploadStrategy {
    /**
     * 上传文件
     *
     * @param file 文件
     * @param path 上传路径
     * @return {@link String} 文件地址
     */
    String uploadFile(MultipartFile file,String path);
}
