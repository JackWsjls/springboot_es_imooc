package cn.imooc.demo.springboot.es;

import cn.imooc.demo.springboot.es.entity.es.EsBlog;
import cn.imooc.demo.springboot.es.repository.es.EsBlogRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootEsApplicationTests {

    @Autowired
    EsBlogRepository blogRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testEs() {
        Iterable<EsBlog> all = blogRepository.findAll();
        Iterator<EsBlog> iterator = all.iterator();
        EsBlog abc = iterator.next();
        System.out.println("=========="+abc.getTitle());
    }
// Elasticsearch exception [type=json_parse_exception, reason=Current token (VALUE_NUMBER_INT) not of boolean type 报错
//错误原因：当前最新版springboot 2.4.0 相匹配的spring-boot-starter-data-elasticsearch支持的是elasticsearch 7.x.x版本 然而本门课程使用的是6.3.2
//解决方法：
//方法一：升级elasticsearch到7.x.x版本
//方法二：使用过去的springboot版本 我尝试了2.2.0.RELEASE 这个错误就不再出现了 推荐此方法因为比较容易修改只需更新pom.xml
//<parent>
//     <groupId>org.springframework.boot</groupId>
//     <artifactId>spring-boot-starter-parent</artifactId>
//     <version>2.2.0.RELEASE</version>
//     <relativePath/> <!-- lookup parent from repository -->
//</parent>
}
