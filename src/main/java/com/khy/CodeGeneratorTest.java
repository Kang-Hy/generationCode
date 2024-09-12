package com.khy;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author kanghaiyang
 */
public class CodeGeneratorTest {
    private static final String URL = "jdbc:mysql://localhost:3306/file?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    private static final String PARENTPACKAGE = "com.khy";

    public static void main(String[] args) {
        FastAutoGenerator.create(URL, USERNAME, PASSWORD)
                .globalConfig((scanner, builder) -> builder
                        .author("khy")
                        .outputDir(scanner.apply("请输入输出路径？") + "/src/main/java")
                        .commentDate("yyyy-MM-dd")
                        .disableOpenDir()
                )
                .packageConfig((scanner, builder) -> builder
                        .parent(PARENTPACKAGE)
                        .moduleName(scanner.apply("请输入模块名？"))
                        .controller("controller")
                        .service("service")
                        .serviceImpl("service.impl")
                        .mapper("mapper")
                        .entity("entity")
                        .xml("mappers")
                        .pathInfo(Collections.singletonMap(OutputFile.xml, "src/main/resources/mapper/" + scanner.apply("请输入模块名？")))
                )
                .strategyConfig((scanner, builder) -> builder
                                .addInclude(scanner.apply("请输入表名？"))
                                .entityBuilder() //.javaTemplate("/templates/entity.java") // 设置实体类模板
                                .enableChainModel()
                                .enableLombok() // 启用 Lombok
                                .logicDeleteColumnName("del")
                                .idType(IdType.INPUT)
                                .enableTableFieldAnnotation() // 启用字段注解
                                //xml和control自定义模板
//                    .serviceBuilder()//.serviceTemplate("/templates/service.java").serviceImplTemplate("/templates/serviceImpl.java")
                                .controllerBuilder().template("/templates/control.java")
                                .mapperBuilder().mapperXmlTemplate("/templates/mapper.xml")//.mapperTemplate("/templates/mapper.java")
                )
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();

    }


}