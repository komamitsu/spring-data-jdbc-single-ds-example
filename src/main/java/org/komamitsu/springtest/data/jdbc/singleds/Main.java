package org.komamitsu.springtest.data.jdbc.singleds;

import org.komamitsu.springtest.data.jdbc.singleds.domain.model.User;
import org.komamitsu.springtest.data.jdbc.singleds.domain.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
@EnableJdbcRepositories
public class Main {
  private static final Logger logger = LoggerFactory.getLogger(Main.class);

  @Autowired
  JdbcTemplate template;

  @Autowired
  UserRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  private void setUpSchema() throws IOException {
    ClassPathResource resource = new ClassPathResource("pg-schema.sql");
    Files.readAllLines(Paths.get(resource.getURI())).forEach(ddl -> template.execute(ddl));
  }

  @Bean
  public CommandLineRunner run() throws Exception {
    return (String[] args) -> {
      setUpSchema();

      repository.save(new User("komamitsu"));

      System.out.println(repository.findAll());
    };
  }
}
