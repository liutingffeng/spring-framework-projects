package spring_dao.jdbc.a_quickstart;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateQuickstartApplication {

    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_dao?characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("523741ltf");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.execute("insert into tbl_user (name, tel) values ('hahaha', '12345')");
    }
}
