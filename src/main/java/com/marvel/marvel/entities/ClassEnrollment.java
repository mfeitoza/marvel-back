package com.marvel.marvel.entities;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "classes_enrollments")
public class ClassEnrollment {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", updatable = false, nullable = false)
  private String id;

  private Date date;
  private Boolean active;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;

  
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "class_id", referencedColumnName = "id")
  private CourseClass courseClass;

  private Integer test_1;
  private Integer test_2;
  private Integer assignment_1;
  private Integer assignment_2;

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getDate() {
    return this.date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Boolean isActive() {
    return this.active;
  }

  public Boolean getActive() {
    return this.active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public CourseClass getCourseClass() {
    return this.courseClass;
  }

  public void setCourseClass(CourseClass courseClass) {
    this.courseClass = courseClass;
  }


  public Integer getTest_1() {
    return this.test_1;
  }

  public void setTest_1(Integer test_1) {
    this.test_1 = test_1;
  }

  public Integer getTest_2() {
    return this.test_2;
  }

  public void setTest_2(Integer test_2) {
    this.test_2 = test_2;
  }

  public Integer getAssignment_1() {
    return this.assignment_1;
  }

  public void setAssignment_1(Integer assignment_1) {
    this.assignment_1 = assignment_1;
  }

  public Integer getAssignment_2() {
    return this.assignment_2;
  }

  public void setAssignment_2(Integer assignment_2) {
    this.assignment_2 = assignment_2;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof ClassEnrollment)) {
      return false;
    }
    ClassEnrollment classEnrollment = (ClassEnrollment) o;
    return Objects.equals(id, classEnrollment.id) && Objects.equals(date, classEnrollment.date)
        && Objects.equals(active, classEnrollment.active) && Objects.equals(user, classEnrollment.user)
        && Objects.equals(courseClass, classEnrollment.courseClass);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

}
