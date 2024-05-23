package org.example.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@ComponentScan("org.example.components")
public class MyConfig {

    ApplicationContext applicationContext;

    // 커넥션 풀 생성...
    @Bean(destroyMethod = "close")
    public DataSource dataSource(){
        BasicDataSource bds = new BasicDataSource();
//        bds.setInitialSize(10);
        bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        bds.setUrl("jdbc:mysql://127.0.0.1/khj");
        bds.setUsername("root");
        bds.setPassword("1234");
        return bds;
    }

    // sql mapper 공장
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:sql/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    // sql 문장 사용하는 객체
    @Bean
    public SqlSession sqlSession() throws Exception{
        return new SqlSessionTemplate(sqlSessionFactoryBean());
    }
}
