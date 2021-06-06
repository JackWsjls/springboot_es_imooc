package cn.imooc.demo.springboot.es.entity.es;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @author wsjls
 */
@Data
@Document(indexName = "blog",type="_doc",
        useServerConfiguration = true, createIndex = false)
//旧版本ES必须指定type，新版java api默认type为_doc https://www.cnblogs.com/bincoding/p/13525827.html
//@Document(indexName = "blog",type="doc",
//        useServerConfiguration = true, createIndex = false)
public class EsBlog {

    @Id
    private Integer id;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String author;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String content;
    @Field(type = FieldType.Date, format = DateFormat.custom,
            pattern = "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis")
    @JsonAlias(value = "create_time")
    private Date createTime;
    @Field(type = FieldType.Date, format = DateFormat.custom,
            pattern = "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis")
    @JsonAlias(value = "update_time")
    private Date updateTime;
}
