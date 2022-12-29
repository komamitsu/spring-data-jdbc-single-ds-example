package org.komamitsu.springtest.data.jdbc.singleds.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
public class User {
  @Id
  public Integer id;

  public String name;

  public User() {
  }

  public User(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public User(String name) {
    this.name = name;
  }
}
