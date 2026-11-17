package com.bottlecap.aicode.generator;

import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.GlobalConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Codegen {

    public static void main(String[] args) {
        // 配置数据源
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:postgresql://127.0.0.1:5432/aicode");
        dataSource.setUsername("postgres");
        dataSource.setPassword("123456");

        // 创建配置内容，两种风格都可以。
        GlobalConfig globalConfig = createGlobalConfig();

        // 通过 datasource 和 globalConfig 创建代码生成器
        Generator generator = new Generator(dataSource, globalConfig);

        // 生成代码
        generator.generate();
    }

    public static GlobalConfig createGlobalConfig() {
        // 创建配置内容
        GlobalConfig globalConfig = new GlobalConfig();

        // 设置根包
        globalConfig.getPackageConfig()
                .setBasePackage("com.bottlecap.aicode.user");

        // 设置表前缀和只生成哪些表，setGenerateTable 未配置时，生成所有表
        globalConfig.getStrategyConfig()
                .setTablePrefix("aicode_")
                .setGenerateTable("aicode_user")
                .setLogicDeleteColumn("deleted");

        // 设置生成 entity 并启用 Lombok
        globalConfig.enableEntity()
                .setWithLombok(true)
                .setJdkVersion(25);
        // 设置生成 mapper
        globalConfig.enableMapper();
        // 设置生成 service
        globalConfig.enableService();
        globalConfig.enableServiceImpl();
        // 设置生成 controller
        globalConfig.enableController();

        return globalConfig;
    }
}