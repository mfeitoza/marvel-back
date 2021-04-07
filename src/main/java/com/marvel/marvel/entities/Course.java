package com.marvel.marvel.entities;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "courses")
public class Course {
  
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", updatable = false, nullable = false)
  private String id;

  @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
  private List<CourseClass> classes;

  private String name;
  private Integer workload;
  private String description;

  protected Course() {
  }


}
