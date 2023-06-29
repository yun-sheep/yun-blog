package com.yun.foregroundmanagement.common.config;

import com.yun.foregroundmanagement.common.components.SwaggerCore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @Description swagger配置类
 * @auther j2-yizhiyang
 * @date 2023/4/30 14:39
 */
@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {
    @Bean
    Docket foregroundApi(){
        return SwaggerCore.defaultDocketBuilder("基础信息模块",
                "com.yun.foregroundmanagement",
                   "foreground");
    }
}
