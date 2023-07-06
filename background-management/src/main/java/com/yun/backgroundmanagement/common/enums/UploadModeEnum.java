package com.yun.backgroundmanagement.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 上传模式枚举
 * @auther j2-yizhiyang
 * @date 2023/5/3 14:33
 */
@Getter
@AllArgsConstructor
public enum UploadModeEnum {
    OSS("oss", "ossUploadStrategyImpl"),
    COS("cos","CosUploadStrategyImpl");
    //MINIO("minio", "minioUploadStrategyImpl");
    private final String mode;

    private final String strategy;
    /**
     * 上传文件(根据路径和上传文件进行上传）
     *
     * @param mode 上传模式
     * @return 执行上传的策略（要根据这个调用相应的上传策略）
     */
    public static String GetStrategy(String mode) {
        for (UploadModeEnum value : UploadModeEnum.values()) {
            if (value.getMode().equals(mode)) {
                return value.getStrategy();
            }
        }
        return null;
    }
}
