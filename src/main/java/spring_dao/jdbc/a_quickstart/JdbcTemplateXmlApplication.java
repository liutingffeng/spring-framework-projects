package spring_dao.jdbc.a_quickstart;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateXmlApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc/spring-jdbc.xml");
        JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
        jdbcTemplate.execute("insert into tbl_account (user_id, money) values (3, 100)");
    }
}
