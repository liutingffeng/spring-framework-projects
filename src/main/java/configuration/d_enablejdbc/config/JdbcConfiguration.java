package configuration.d_enablejdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import configuration.d_enablejdbc.anno.ConditionalOnClassName;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JdbcConfiguration {

    @Bean
    @ConditionalOnClassName("com.mysql.jdbc.Driver")
    public DataSource mysqlDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

    @Bean
    @ConditionalOnClassName("org.h2.Driver")
    public DataSource h2DataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:tcp://localhost/D:/Program Files (x86)/H2/bin/sea");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

//    @Bean
//    public QueryRunner queryRunner(DataSource dataSource) {
//        return new QueryRunner(dataSource);
//    }
}
