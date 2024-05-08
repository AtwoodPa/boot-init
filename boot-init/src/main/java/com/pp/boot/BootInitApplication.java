package com.pp.boot;

import io.undertow.UndertowOptions;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

/**
 * 启动类
 * 使用Undertow作为服务器
 */
@MapperScan("com.pp.boot.mapper")
@SpringBootApplication
public class BootInitApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BootInitApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BootInitApplication.class);
    }

    @Bean
    public UndertowServletWebServerFactory undertowFactory() {
        UndertowServletWebServerFactory factory = new UndertowServletWebServerFactory();
        factory.addBuilderCustomizers(
                builder -> builder.setServerOption(UndertowOptions.ENABLE_HTTP2, true)); // 可选：启用 HTTP/2
        return factory;
    }
}
