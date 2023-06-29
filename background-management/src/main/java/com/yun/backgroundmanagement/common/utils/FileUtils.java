package com.yun.backgroundmanagement.common.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.codec.binary.Hex;
import org.springframework.util.MimeTypeUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description 文件工具类
 * @auther j2-yizhiyang
 * @date 2023/5/2 15:25
 */
public class FileUtils {
    /**
     * 获取文件md5值
     *
     * @param inputStream 文件输入流
     * @return {@link String} 文件md5值
     */
    public static String getMd5(InputStream inputStream) throws IOException {
        try {
            //该方法会逐块读取文件内容，并在每次读取后更新MD5摘要。最后，它将MD5摘要转换为十六进制字符串表示，并返回结果
            MessageDigest md5 = MessageDigest.getInstance("md5");
            byte[] buffer = new byte[8192];
            int length;
            while ((length = inputStream.read(buffer)) != -1){
                //md5Digest 对象将包含文件的完整摘要信息
                md5.update(buffer,0,length);
            }
            return new String(Hex.encodeHex(md5.digest()));

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try{
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 获取文件名的后缀
     *
     * @param file 表单文件
     * @return 后缀名
     */
    public static String getExtension(MultipartFile file){
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        if(StringUtils.isEmpty(extension)){
            //TODO 获取文件后缀名
            extension = "自定义";
        }
        return extension;
    }
    /**
     * 创建目录
     *
     * @param file 文件
     * @return 是否创建成功
     */
    public static boolean mkdir(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return false;
        }
        return file.mkdirs();
    }
    /**
     * 删除文件
     *
     * @param src 文件
     */
    public static void deleteFile(File src) {
        for (File file : src.listFiles()) {
            if (file.isFile()) {
                file.delete();
            } else {
                deleteFile(file);
            }
        }
        src.delete();
    }
}
