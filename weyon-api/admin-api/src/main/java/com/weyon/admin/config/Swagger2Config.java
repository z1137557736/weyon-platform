package com.weyon.admin.config;

import com.google.common.collect.Lists;
import com.weyon.framework.constant.RedisConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author liuxu
 * @description swagger2控制类
 * @date 2019-07-15
 **/

@Configuration
public class Swagger2Config {

    @Bean
    public Docket docket() {
        ParameterBuilder builder = new ParameterBuilder();
        // 在swagger里显示header
        builder.parameterType("header").name(RedisConstant.HEADER_TOKEN)
                .description("header参数")
                .required(false)
                .modelRef(new ModelRef("string"));

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder().title("省级平台（系统管理）restful API").version("1.0").build())
                .globalOperationParameters(Lists.newArrayList(builder.build()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.weyon"))
                .paths(PathSelectors.any())
                .build();
    }
}
