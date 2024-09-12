package com.khy;


import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybaitsPulsDemoApplicationTests {

    @Test
    void FastAutoGenerator() {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/file?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("khy") // 设置作者
                            .outputDir("src/main/java"); // 输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.khy.user") // 设置父包名
                            .entity("model") // 设置实体类包名
                            .mapper("dao") // 设置 Mapper 接口包名
                            .service("service") // 设置 Service 接口包名
                            .serviceImpl("service.impl") // 设置 Service 实现类包名
                            .xml("mappers"); // 设置 Mapper XML 文件包名
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user") // 设置需要生成的表名
                            .entityBuilder()
                            .enableLombok() // 启用 Lombok
                            .enableTableFieldAnnotation() // 启用字段注解
                            .controllerBuilder()
                            .enableRestStyle(); // 启用 REST 风格
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute(); // 执行生成
    }

    @Test
    void generateCodeTest() {
        generateCode();
    }

    private void generateCode() {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/file?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC", "root", "123456")
                .globalConfig(builder -> builder
                        .author("khy")
                        .outputDir("D:\\demo\\mybaits-puls-demo" + "/src/main/java")
                        .commentDate("yyyy-MM-dd")
                )
                .packageConfig((scanner, builder) -> builder
                        .parent("com.khy" + scanner.apply("请输入包名？"))
                        .entity("entity")
                        .mapper("mapper")
                        .service("service")
                        .serviceImpl("service.impl")
                        .xml("mapper.xml")
                )
                .strategyConfig(builder -> builder
                        .addInclude("user")
                        .entityBuilder()
                        .enableLombok()
                )
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

}
