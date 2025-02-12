package com.example.diploma.config;

import static com.example.diploma.config.ReadMessageConfig.getMessage;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class SwaggerConfig {

    private static final String TITLE = "DairyAPI";
    private static final String DESCRIPTION = "Service to manage dairy";

    @Bean
    public OpenAPI customOpenAPI(@Value("${server.servlet.context-path}") String contextPath) {
        return new OpenAPI()
                .addServersItem(new Server().url(contextPath))
                .info(new Info()
                        .title(TITLE)
                        .description(DESCRIPTION)
                        .version("v1")
                );
    }

//    @Bean
//    public OpenApiCustomizer openApiCustomiser(MessageSource messageSource) {
//        return openApi -> {
//            for (PathItem pathItem : openApi.getPaths().values()) {
//                processOperations(pathItem.getGet(), messageSource);
//                processOperations(pathItem.getPost(), messageSource);
//                processOperations(pathItem.getPut(), messageSource);
//                processOperations(pathItem.getDelete(), messageSource);
//                processOperations(pathItem.getPatch(), messageSource);
//            }
//        };
//    }
//
//    private void processOperations(Operation operation, MessageSource messageSource) {
//        if (operation == null) return;
//
//        operation.getResponses().forEach((code, apiResponse) -> {
//            String description = apiResponse.getDescription();
//            if (description != null) {
//                String updatedDescription = replaceResourceBundleKeys(description, messageSource);
//                apiResponse.setDescription(updatedDescription);
//            }
//        });
//    }
//
//    private String replaceResourceBundleKeys(String text, MessageSource messageSource) {
//        Pattern pattern = Pattern.compile("\\{([^}]+)\\}");
//        Matcher matcher = pattern.matcher(text);
//        StringBuilder result = new StringBuilder();
//
//        while (matcher.find()) {
//            String key = matcher.group(1);
//            matcher.appendReplacement(result, getMessage(key));
//        }
//        matcher.appendTail(result);
//
//        return result.toString();
//    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
