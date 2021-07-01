package com.marvel.marvel.entities;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Column;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "classes")
public class CourseClass {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", updatable = false, nullable = false)
  private String id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "course_id", nullable = false)
  private Course course;

  private String location;
  private Integer availablePlaces;
  private Date startDate;
  private Date endDate;
  private String professorId;


  protected CourseClass() {
  }

  public CourseClass(String id, String location, Integer availablePlaces,
      Date startDate, Date endDate, String courseId, String professorId) {
    this.id = id;
    this.location = location;
    this.availablePlaces = availablePlaces;
    this.startDate = startDate;
    this.endDate = endDate;
    this.professorId = professorId;
  }

  public CourseClass(String location, Integer availablePlaces, Date startDate, Date endDate,
      String courseId, String professorId) {
    this.location = location;
    this.availablePlaces = availablePlaces;
    this.startDate = startDate;
    this.endDate = endDate;
    this.professorId = professorId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public Integer getAvailablePlaces() {
    return availablePlaces;
  }

  public void setAvailablePlaces(Integer availablePlaces) {
    this.availablePlaces = availablePlaces;
  }

  public String getProfessorId() {
    return professorId;
  }

  public void setProfessorId(String professorId) {
    this.professorId = professorId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CourseClass other = (CourseClass) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  
}
