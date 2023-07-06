package com.yun.backgroundmanagement.common.strategy.impl;

import com.yun.backgroundmanagement.common.strategy.UploadStrategy;

import com.yun.backgroundmanagement.common.utils.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description 抽象上传模板
 * @auther j2-yizhiyang
 * @date 2023/5/2 15:23
 */
//TODO 这个架构为什么要用抽象类，直接用接口不行码(设计模式：
public abstract class AbstractUploadImpl implements UploadStrategy {
    @Override
    public String uploadFile(MultipartFile file, String path) {
        try{
            //获取文件的md5值
            String md5 = FileUtils.getMd5(file.getInputStream());
            //获取文件扩展名
            String extName = FileUtils.getExtension(file);
            //重新生成文件名
            String fileName  =  md5 + "." + extName;
            if (!exists(path + fileName)) {
                // 不存在则继续上传
                upload(path, fileName, file.getInputStream());
            }
            // 返回文件访问路径
            return getFileAccessUrl(path + fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 判断文件是否存在
     *
     * @param filePath 文件路径
     * @return {@link Boolean}
     */
    public abstract Boolean exists(String filePath);
    /**
     * 上传
     *
     * @param path        路径
     * @param fileName    文件名
     * @param inputStream 输入流
     * @throws IOException io异常
     */
    public abstract void upload(String path, String fileName, InputStream inputStream) throws IOException;
    /**
     * 获取文件访问url
     *
     * @param filePath 文件路径
     * @return {@link String} 文件url
     */
    public abstract String getFileAccessUrl(String filePath);
}
