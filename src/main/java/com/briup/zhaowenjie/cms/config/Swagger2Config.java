package com.briup.zhaowenjie.cms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * swagger配置类
 * @author wangzh
 *
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
	
	@Bean
    public Docket demoApi() {
		/*
		 * 当使用令牌时，添加下方return以上语句以为swagger添加令牌输入口
		 */
		ParameterBuilder tokenPar = new ParameterBuilder();
		List<Parameter> pars = new ArrayList<>();
		tokenPar.name("Authorization").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
		pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.briup.zhaowenjie.cms.web"))
                .paths(PathSelectors.any())
                .build()
				.globalOperationParameters(pars)//添加该句使得swagger可输入令牌
                .apiInfo(apiInfo());

    }


	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("看点资讯")
				.description("杰普学员-暗风")
				.termsOfServiceUrl("http://www.briup.com")
				.version("0.1")
				.build();
	}
}

