package com.marvel.marvel.entities;

import java.util.List;
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

  public Course(String id, List<CourseClass> classes, String name, Integer workload, String description) {
    this.id = id;
    this.classes = classes;
    this.name = name;
    this.workload = workload;
    this.description = description;
  }

  public Course(String name, String description, Integer workload) {
    this.name = name;
    this.workload = workload;
    this.description = description;
  }

  public String getId() {
    return id;
  }
  
  public List<CourseClass> getClasses() {
    return classes;
  }

  public void setClasses(List<CourseClass> classes) {
    this.classes = classes;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getWorkload() {
    return workload;
  }

  public void setWorkload(Integer workload) {
    this.workload = workload;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
