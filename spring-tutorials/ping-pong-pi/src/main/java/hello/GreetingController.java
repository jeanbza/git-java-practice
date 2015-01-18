package hello;

import javax.sql.DataSource;
import org.springframework.jdbc.core.*;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) throws SQLException {
//        MysqlDataSource mysqlDS = new MysqlDataSource();
//        mysqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
//        mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
//        mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
//
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(mysql);
//
//        List<String> results = jdbcTemplate.query(
//            "select boom from test.bam where first_name = ?", new Object[] { "Josh" },
//            new RowMapper<String>() {
//                @Override
//                public String mapRow(ResultSet rs, int rowNum) throws SQLException {
//                    return rs.getString("boom");
//                }
//            }
//        );
//
//        System.out.println(results);

        return new Greeting(counter.incrementAndGet(), "boom");
    }
}
