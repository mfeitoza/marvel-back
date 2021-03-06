package com.marvel.marvel.entities;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "documents")
public class Document {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", updatable = false, nullable = false)
  private String id;
  private String type;
  private String value;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  protected Document() {
  }

  public Document(String id, String type, String value, String user_id) {
    this.id = id;
    this.type = type;
    this.value = value;
  }

  public Document(String type, String value) {
    this.type = type;
    this.value = value;
  }

  public String getId() {
    return this.id;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Document)) {
      return false;
    }
    Document document = (Document) o;
    return Objects.equals(id, document.id) && Objects.equals(type, document.type)
        && Objects.equals(value, document.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

}
