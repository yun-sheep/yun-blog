package com.yun.backgroundmanagement.common.strategy.context;

import com.yun.backgroundmanagement.common.strategy.UploadStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

import static com.yun.backgroundmanagement.common.enums.UploadModeEnum.GetStrategy;

/**
 * @Description 上传策略上下文（根据上传策略选择合适实现类来实现上传）
 * @auther j2-yizhiyang
 * @date 2023/5/3 14:29
 */
@Service
public class UploadStrategyContext {
    /**
     * 上传模式
     */
    //@Value("${upload.strategy}")
    @Value("cos")
    private String uploadStrategy;

    @Autowired
    private Map<String, UploadStrategy> uploadStrategyMap;
    /**
     * 上传文件(根据路径和上传文件进行上传）
     *
     * @param file 文件
     * @param path 路径
     * @return {@link String} 文件地址
     */
    public String executeUploadStrategy(MultipartFile file,String path){
        return uploadStrategyMap.get(GetStrategy(uploadStrategy)).uploadFile(file, path);
    }
}
