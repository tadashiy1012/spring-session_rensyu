package tadashiy;

import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Main {
  @Autowired
  private JdbcTemplate jdbc;
  public static void main(String[] args) {
    ConfigurableApplicationContext ctx = SpringApplication.run(Main.class, args);
  }
  void method() {
    jdbc.execute("CREATE TABLE TEST_TABLE (ID INTEGER NOT NULL IDENTITY, VALUE VARCHAR(256))");
    jdbc.update("INSERT INTO TEST_TABLE (VALUE) VALUES (?)", "hoge");
    List<Map<String, Object>> list = jdbc.queryForList("SELECT * FROM TEST_TABLE");
    list.forEach(System.out::println);
  }
}