package com.yun.backgroundmanagement.common.componet;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;

/**
 * @Description swagger工具类
 * @auther j2-yizhiyang
 * @date 2023/4/30 14:34
 */
public class SwaggerCore {
    public static Docket defaultDocketBuilder(String projectName, String apiBasePackage, String groupName) {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(apiBasePackage))
                .paths(PathSelectors.any())
                .build()
                .groupName(groupName)
                .apiInfo(createApiInfo(projectName))
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }
    /**
     * 构建文档说明对象
     *
     * @param projectName 项目名称
     * @return ApiInfo对象
     */
    private static ApiInfo createApiInfo(String projectName) {
        return new ApiInfoBuilder()
                .title(projectName + " API接口服务")
                .description("用于" + projectName + "前后端交互，提供一套API说明")
                .version("1.0.0")
                .contact(new Contact("yun-blog", "https://space.bilibili.com/1653229811/?spm_id_from=333.999.0.0", "1411770226@qq.com"))
                .license("Apache 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }
    /**
     * 构建权限协议列表
     *
     * @return 认证协议列表
     */
    private static List<SecurityScheme> securitySchemes() {
        return Collections.singletonList(
                new ApiKey("Authorization", "Authorization", "header"));
    }
    /**
     * 构建权限上下文列表
     *
     * @return 认证上下文列表
     */
    private static List<SecurityContext> securityContexts() {
        return Collections.singletonList(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .build()
        );
    }
    /**
     * 构建默认认证作用域列表
     *
     * @return 认证作用域列表
     */
    private static List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections.singletonList(new SecurityReference("Authorization", authorizationScopes));
    }
}
