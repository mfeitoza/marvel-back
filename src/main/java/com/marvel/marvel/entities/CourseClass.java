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
  private Integer avaliablePlaces;
  private Date startDate;
  private Date endDate;

  protected CourseClass() {

  }

  public CourseClass(String id, String location, Integer avaliablePlaces, Date startDate, Date endDate) {
    this.id = id;
    this.location = location;
    this.avaliablePlaces = avaliablePlaces;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public CourseClass(String location, Integer avaliablePlaces, Date startDate, Date endDate) {
    this.location = location;
    this.avaliablePlaces = avaliablePlaces;
    this.startDate = startDate;
    this.endDate = endDate;
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

  public Integer getAvaliablePlaces() {
    return avaliablePlaces;
  }

  public void setAvaliablePlaces(Integer avaliablePlaces) {
    this.avaliablePlaces = avaliablePlaces;
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
