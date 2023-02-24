package com.test;

import cn.org.atool.generator.FileGenerator;
import cn.org.atool.generator.annotation.Column;
import cn.org.atool.generator.annotation.Table;
import cn.org.atool.generator.annotation.Tables;
import org.junit.jupiter.api.Test;

/**
 * @author aoe
 * @date 2021/10/27
 */
public class EntityGeneratorTests {

    static final String url = "jdbc:mysql://localhost:3306/geektime-ddd?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&allowMultiQueries=true";

    // orgmng
    static final String MODEL = "orgmng";

    @Test
    public void generate() {
        FileGenerator.build(Abc.class);
    }

    @Tables(
            /* 数据库连接信息 **/
            url = url, username = "root", password = "root",
            /* Entity类parent package路径 **/
            basePack = "com.wyyl1.hi.adapter.driving.persistence." + MODEL,
            /* Entity代码源目录 **/
            srcDir = "src/main/java/",
            /* Dao代码源目录 **/
//            daoDir = "src/main/java/",
            /* 如果表定义记录创建，记录修改，逻辑删除字段 **/
            gmtCreated = "gmt_created", gmtModified = "gmt_modified", logicDeleted = "is_deleted",
            /* 需要生成文件的表 ( 表名称:对应的Entity名称 ) **/
            tables = @Table(
                    value = {
                            "org:Org"
                    },
                    columns = @Column(value = "gender_man", javaType = Boolean.class),
                    useDao = false
            ),
            // Entity 字段顺序按数据库定义顺序选项
            alphabetOrder = false
    )
    static class Abc {
    }
}
