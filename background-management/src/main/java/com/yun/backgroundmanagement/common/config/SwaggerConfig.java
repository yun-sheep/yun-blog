package com.yun.backgroundmanagement.common.config;

import com.yun.backgroundmanagement.common.componet.SwaggerCore;
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
        return SwaggerCore.defaultDocketBuilder("后台管理系统",
                "com.yun.backgroundmanagement",
                   "background");
    }
}
