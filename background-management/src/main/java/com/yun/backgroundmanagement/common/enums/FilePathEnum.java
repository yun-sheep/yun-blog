package com.yun.backgroundmanagement.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 文件上传路径枚举类
 * @auther j2-yizhiyang
 * @date 2023/5/3 14:44
 */
@Getter
@AllArgsConstructor
public enum FilePathEnum {
    AVATAR("aurora/avatar/", "头像路径"),

    ARTICLE("aurora/articles/", "文章图片路径"),

    VOICE("aurora/voice/", "音频路径"),

    PHOTO("aurora/photos/", "相册路径"),

    CONFIG("aurora/config/", "配置图片路径"),

    TALK("aurora/talks/", "配置图片路径"),

    MD("aurora/markdown/", "md文件路径");

    private final String path;

    private final String desc;
}
