package com.weyon.admin;

import com.weyon.common.model.BaseMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author liuxu
 */
@SpringBootApplication(scanBasePackages = "com.weyon")
@EnableDiscoveryClient
@EnableTransactionManagement
@MapperScan(basePackages = "com.weyon.admin.dao", markerInterface = BaseMapper.class)
public class AdminServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminServiceApplication.class, args);
    }

}
