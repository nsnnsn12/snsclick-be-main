package com.snsclicksystem.main.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.snsclicksystem.main.adapter.out.api")
public class FeignClientConfig {
}
