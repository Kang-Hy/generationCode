package com.khy;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.HashMap;

/**
 * @author kanghaiyang
 */
public class CodeGeneratorTest {
    private static final String URL = "jdbc:mysql://localhost:3306/file?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    private static final String PARENTPACKAGE = "com.khy";
    private static final String PARENTPATH = PARENTPACKAGE.replace(".", "/");

    public static void main(String[] args) {
        generate();
//        generate2();
    }

    //一堆代码写到一个模块里面
    private static void generate() {
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
                        //包名
                        .controller("controller")
                        .service("service")
                        .serviceImpl("service.impl")
                        .mapper("mapper")
                        .entity("entity")
                        .xml("mappers")
                        //自定义输出位置，没有自定义的就输出到.outputDir(scanner.apply("请输入输出路径？") + "/src/main/java")下的/parent/moduleName
                        .pathInfo(new HashMap<OutputFile, String>() {{
                            put(OutputFile.xml, "src/main/resources/mapper/" + scanner.apply("请输入.xml放到resources/mapper哪下面哪个包里（模块名）？"));
                            //指定了模块名又自定义输出位置要修改模板package --这里指定了锁有entity输出到指定文件夹，就要修改entity的模板
                            // put(OutputFile.entity, "src/main/java/com/khy/entity");
                        }})
                )
                .strategyConfig((scanner, builder) -> builder
                        .addInclude(scanner.apply("请输入表名？"))
                        .entityBuilder()
                        .javaTemplate("/templates/entity.java") // 设置实体类模板
                        .enableChainModel()
                        .enableLombok() // 启用 Lombok
                        .logicDeleteColumnName("del")
                        .idType(IdType.INPUT)
                        .enableTableFieldAnnotation() // 启用字段注解
                        //自定义模板
                        .serviceBuilder().serviceTemplate("/templates/service.java").serviceImplTemplate("/templates/serviceImpl.java")
                        .controllerBuilder().template("/templates/controller.java").enableRestStyle()
                        .mapperBuilder().mapperXmlTemplate("/templates/mapper.xml").mapperTemplate("/templates/mapper.java").enableBaseResultMap().enableBaseColumnList()
                )
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    //control写到一堆 service写到一堆
    private static void generate2() {
        FastAutoGenerator.create(URL, USERNAME, PASSWORD)
                .globalConfig((scanner, builder) -> builder
                        .author("khy")
                        .outputDir(scanner.apply("请输入输出路径？"))
                        .commentDate("yyyy-MM-dd")
                        .disableOpenDir()
                )
                .packageConfig((scanner, builder) -> builder
                        .parent(PARENTPACKAGE)
                        //包名
                        .controller("controller")
                        .service("service")
                        .serviceImpl("service.impl")
                        .mapper("mapper")
                        .entity("entity")
                        .xml("mappers")
                        .pathInfo(new HashMap<OutputFile, String>() {{
                            put(OutputFile.xml, "src/main/resources/mapper");
                            put(OutputFile.entity, "src/main/java/" + PARENTPATH + "/entity");
                            put(OutputFile.mapper, "src/main/java/" + PARENTPATH + "/mapper");
                            put(OutputFile.service, "src/main/java/" + PARENTPATH + "/service");
                            put(OutputFile.serviceImpl, "src/main/java/" + PARENTPATH + "/service/serviceImpl");
                            put(OutputFile.controller, "src/main/java/" + PARENTPATH + "/controller");
                        }})
                )
                .strategyConfig((scanner, builder) -> builder
                        .addInclude(scanner.apply("请输入表名？"))
                        .entityBuilder()
                        .javaTemplate("/templates/entity.java") // 设置实体类模板
                        .enableChainModel()
                        .enableLombok() // 启用 Lombok
                        .logicDeleteColumnName("del")
                        .idType(IdType.INPUT)
                        .enableTableFieldAnnotation() // 启用字段注解
                        //自定义模板
                        .serviceBuilder().serviceTemplate("/templates/service.java").serviceImplTemplate("/templates/serviceImpl.java")
                        .controllerBuilder().template("/templates/controller.java").enableRestStyle()
                        .mapperBuilder().mapperXmlTemplate("/templates/mapper.xml").mapperTemplate("/templates/mapper.java").enableBaseResultMap().enableBaseColumnList()
                )
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }


}